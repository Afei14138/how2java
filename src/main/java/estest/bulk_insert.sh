#!/bin/bash

split -l 100000 -a 10 data.json ./tmp/carrier_bulk

BULK_FILES=./tmp/carrier_bulk*
for f in $BULK_FILES; do
    curl -s -XPOST http://localhost:9200/_bulk --data-binary @$f >> /dev/null
    echo $f >> ./import.log
done