#!/usr/bin/env bash

kbport=${1:-9401}
catalogueport=${2:-9402}

npm install -g webpack

npm install -g webpack-dev-server

./start-registered.sh ${kbport} ${catalogueport}

cd demo/ui

npm install

webpack-dev-server --host 0.0.0.0

