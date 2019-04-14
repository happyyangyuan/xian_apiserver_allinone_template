#!/usr/bin/env bash

cd `dirname $0`
rm -rf *.jar
gradle clean fatJar renameFatJar