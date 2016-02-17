#!/usr/bin/env bash

./solr-5.4.1/bin/solr start -noprompt -Djava.library.path=/usr/local/bin/mecab-java 1> /dev/null 2>&1 &

