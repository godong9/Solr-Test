#!/usr/bin/env bash

./stop_solr.sh

sleep 5;

pkill mongo-connector

./start_solr.sh

sleep 5;

rm oplog_ts/oplog.timestamp
rm logs/mongo-connector.log

sleep 3;

./dev_start_mongo_connector.sh
