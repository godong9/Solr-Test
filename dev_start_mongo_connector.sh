#!/usr/bin/env bash

export PYTHONPATH=.

nohup mongo-connector -c dev_config.json 1> /dev/null 2>&1 &