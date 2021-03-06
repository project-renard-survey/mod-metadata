package org.folio.knowledgebase.core.api.representation

import io.vertx.groovy.core.http.HttpServerRequest
import org.folio.knowledgebase.core.api.ResourceMap
import org.folio.knowledgebase.core.domain.Instance

class InstanceRepresentation {
  static toMap(Instance instance, HttpServerRequest request) {
    def representation = [:]

    representation."@context" = ResourceMap.instanceMetadataAbsolute(request)

    representation.title = instance.title
    representation.links = ['self': ResourceMap.instanceAbsolute("/${instance.id}", request)]

    representation.identifiers = []

    instance.identifiers.each { identifier ->
      def identifierRepresentation = [:]

      identifierRepresentation.namespace = identifier.namespace
      identifierRepresentation.value = identifier.value

      representation.identifiers << identifierRepresentation
    }

    representation
  }
}
