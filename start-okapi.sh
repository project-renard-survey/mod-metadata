#!/usr/bin/env bash

#Run this from the root directory of the Okapi source

okapi_proxy_address=${1:-"http://localhost:9130"}

if [ $# == 0 ] ; then
  echo "Using default parameters"
  echo "Okapi Address: ${okapi_proxy_address}"
  echo "Usage: ./start-okapi.sh  [okapi proxy address] from the Okapi source root directory"
fi

mvn compile --quiet

java  \
      -Dokapiurl="${okapi_proxy_address}" \
      -Dloglevel=DEBUG \
      -jar okapi-core/target/okapi-core-fat.jar dev
