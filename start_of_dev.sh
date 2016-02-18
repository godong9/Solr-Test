#!/usr/bin/env bash

./stop_solr.sh

sleep 5;

pkill mongo-connector

./start_solr.sh

sleep 5;

./dev_start_mongo_connector.sh
