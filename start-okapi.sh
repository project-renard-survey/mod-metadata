#!/usr/bin/env bash

#Run this from the root directory of the Okapi source

reachableaddress=${1:-localhost}

java  \
      -Dokapiurl="http://${reachableaddress}:9130" \
      -Dloglevel=DEBUG \
      -jar okapi-core/target/okapi-core-fat.jar dev
