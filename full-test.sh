#!/usr/bin/env bash

knowledgebase_direct_address=${1:-http://localhost:9601}
catalogue_direct_address=${2:-http://localhost:9602}

knowledgebase_instance_id=${3:-localhost-9601}
catalogue_instance_id=${4:-localhost-9602}

okapi_address=${5:-http://localhost:9130}

./create-tenant.sh

./register.sh ${knowledgebase_direct_address} ${catalogue_direct_address} ${knowledgebase_instance_id} ${catalogue_instance_id}

gradle -Dokapi.address="${okapi_address}" clean test testApiViaOkapi

./unregister.sh ${knowledgebase_instance_id} ${catalogue_instance_id}

./delete-tenant.sh
