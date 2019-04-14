#!/bin/bash

cd `dirname $0`
pwd

# Create the 'logs' dir if it does not exists.
if [ ! -d "logs" ]; then
  mkdir logs
fi

java -XX:-OmitStackTraceInFastThrow -cp *.jar info.xiancloud.core.init.start.StartServer "${PWD##*/}"

sleep 1


