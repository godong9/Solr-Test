#!/usr/bin/env bash

./stop_solr.sh

pkill mongo-connector

./start_solr.sh

rm oplog_ts/oplog.timestamp
rm logs/mongo-connector.log

./dev_start_mongo_connector.sh
