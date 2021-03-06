package support

import org.folio.catalogue.core.ApiVerticle
import org.folio.catalogue.core.storage.Storage
import io.vertx.groovy.core.Vertx

import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

import static support.HttpClient.get

class World {
  private static vertx
  public static final testPortToUse = 9602

  static reset() {
    Storage.clear()
  }

  static def startVertx() {
    vertx = Vertx.vertx()
    vertx
  }

  static def startApi() {
    ApiVerticle.deploy(vertx, ["port": testPortToUse]).join()
  }

  static def stopVertx() {
    if (vertx != null) {
      def stopped = new CompletableFuture()

      vertx.close({ res ->
        if (res.succeeded()) {
          stopped.complete(null);
        } else {
          stopped.completeExceptionally(res.cause());
        }
      })

      stopped.join()
    }
  }

  static URL itemApiRoot() {
    new URL(get(World.catalogueApiRoot()).links.items)
  }

  static URL catalogueApiRoot() {
    def directAddress = new URL("http://localhost:${testPortToUse}/catalogue")

    def useOkapi = (System.getProperty("okapi.use") ?: "").toBoolean()

    useOkapi ? new URL(System.getProperty("okapi.address") + '/catalogue') : directAddress
  }

  static <T> T getOnCompletion(CompletableFuture<T> future) {
    future.get(2000, TimeUnit.MILLISECONDS)
  }

  static Closure complete(CompletableFuture future) {
    return { future.complete(it) }
  }
}
