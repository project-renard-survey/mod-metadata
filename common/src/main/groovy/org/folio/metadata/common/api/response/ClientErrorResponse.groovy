package org.folio.metadata.common.api.response

import io.vertx.groovy.core.http.HttpServerResponse

class ClientErrorResponse {
  static notFound(HttpServerResponse response) {
    response.setStatusCode(404)
    response.end()
  }

  static badRequest(HttpServerResponse response, String reason) {
    response.setStatusCode(400)
    response.putHeader "content-type", "text/plain"
    response.end(reason)
  }

  static forbidden(HttpServerResponse response, String reason) {
    response.setStatusCode(403)
    response.putHeader "content-type", "text/plain"
    response.end(reason)
  }
}
