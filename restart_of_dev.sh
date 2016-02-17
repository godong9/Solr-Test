#!/usr/bin/env bash

#rm -rf dump_backup
#mv dump dump_backup
#mongodump -d deployd -c notes

./solr-5.4.1/bin/solr stop -all
pkill mongo-connector

#mongo drop_notes.js

#rm -rf ./solr-5.4.1/server/solr/notes/data

./start_solr.sh

rm oplog_ts/oplog.timestamp
rm logs/mongo-connector.log

sleep 5;

./dev_start_mongo_connector.sh

#mongorestore -d deployd -c notes dump/deployd/notes.bson


