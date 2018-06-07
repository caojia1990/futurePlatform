#!/bin/bash
cd `dirname $0`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/conf
LIB_DIR=$DEPLOY_DIR/lib
LIB_JARS=`ls $LIB_DIR|grep .jar|awk '{print "'$LIB_DIR'/"$0}'|tr "\n" ":"`
APP_MAIN=com.future.market.service.MarketMain

###################################
#(函数)判断程序是否已启动
#
#说明： 
#使用JDK自带的JPS命令及grep命令组合，准确查找pid
#jps 加 l 参数，表示显示java的完整包路径
#使用awk，分割出pid ($1部分)，及Java程序名称($2部分)
###################################
#初始化psid变量（全局）
psid=0

checkpid() {
   javaps=`$JAVA_HOME/bin/jps -l | grep $APP_MAIN`
  
   if [ -n "$javaps" ]; then
      psid=`echo $javaps | awk '{print $1}'`
   else
      psid=0
   fi
}

###################################  
#(函数)启动程序  
#  
#说明：  
#1. 首先调用checkpid函数，刷新$psid全局变量  
#2. 如果程序已经启动（$psid不等于0），则提示程序已启动  
#3. 如果程序没有被启动，则执行启动命令行  
#4. 启动命令执行后，再次调用checkpid函数  
#5. 如果步骤4的结果能够确认程序的pid,则打印[OK]，否则打印[Failed]  
#注意：echo -n 表示打印字符后，不换行  
#注意: "nohup 某命令 >/dev/null 2>&1 &" 的用法  
###################################  
start() {
   checkpid
  
   if [ $psid -ne 0 ]; then
      echo "================================"  
      echo "warn: $APP_MAIN already started! (pid=$psid)"
      echo "================================"  
   else
      echo -n "Starting $APP_MAIN ..."
      
      nohup java -Dfile.encoding=UTF-8 -classpath $CONF_DIR:$LIB_JARS$CLASSPATH $APP_MAIN > stdout.log &
      
      checkpid  
      if [ $psid -ne 0 ]; then
         echo "(pid=$psid) [OK]"
      else  
         echo "[Failed]"
      fi
   fi
}
start
exit 0