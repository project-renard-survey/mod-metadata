package org.folio.knowledgebase.core.domain

import org.folio.metadata.common.domain.BatchCollection
import org.folio.metadata.common.domain.Collection

interface InstanceCollection extends Collection<Instance>,
  BatchCollection<Instance> {
  List<Instance> findByTitle(String partialName)

  List<Instance> findByIdentifier(String namespace, String identifier)

  void findByTitle(String partialName, Closure resultCallback)

  void findByIdentifier(String namespace, String identifier, Closure resultCallback)
}
