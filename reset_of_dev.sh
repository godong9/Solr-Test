#!/usr/bin/env bash

./stop_solr.sh
pkill mongo-connector

rm -rf ./solr-5.4.1/server/solr/notes/data

./start_solr.sh

rm oplog_ts/oplog.timestamp
rm logs/mongo-connector.log

sleep 5;

./dev_start_mongo_connector.sh

