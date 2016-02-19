#!/usr/bin/env bash

./stop_solr.sh

pkill mongo-connector

./start_solr.sh

./dev_start_mongo_connector.sh
