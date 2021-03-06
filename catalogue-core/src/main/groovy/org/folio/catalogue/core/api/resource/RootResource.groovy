package org.folio.catalogue.core.api.resource

import io.vertx.core.http.HttpMethod
import io.vertx.core.json.JsonObject
import io.vertx.groovy.ext.web.Router
import io.vertx.groovy.ext.web.RoutingContext
import org.folio.catalogue.core.api.ResourceMap
import org.folio.metadata.common.api.response.JsonResponse

class RootResource {
  static def register(Router router) {
    router.route(HttpMethod.GET, ResourceMap.root()).handler(RootResource.&handleRoot)
  }

  public static void handleRoot(RoutingContext routingContext) {
    def links = [:]

    links << ['items': ResourceMap.itemAbsolute("", routingContext.request())]

    JsonResponse.success(routingContext.response(),
      new JsonObject()
        .put("message", "Welcome to the FOLIO Catalogue Module")
        .put("links", links))
  }
}
