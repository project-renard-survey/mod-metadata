#!/usr/bin/env bash

okapi_proxy_address=${1:-http://localhost:9130}

npm install -g webpack

npm install -g webpack-dev-server

./start-with-sample-data.sh ${okapi_proxy_address}

cd demo/ui

npm install

webpack-dev-server --host 0.0.0.0

