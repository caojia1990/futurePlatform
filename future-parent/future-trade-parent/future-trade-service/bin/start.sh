#!/bin/bash
cd `dirname $0`
cd ..
DEPLOY_DIR=`pwd`
LIB_DIR=$DEPLOY_DIR/lib
LIB_JARS=`ls $LIB_DIR|grep .jar|awk '{print "'$LIB_DIR'/"$0}'|tr "\n" ":"`
nohup java -Dfile.encoding=UTF-8 -classpath $CONF_DIR:$LIB_JARS$CLASSPATH com.future.trade.service.demo.TradeDemo > stdout.log