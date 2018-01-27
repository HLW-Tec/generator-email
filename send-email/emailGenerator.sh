#!/bin/bash
CONTRACT_HOME_DIR=/usr/local/emailGenerator
PATH=$PATH:$CONTRACT_HOME_DIR
export PATH
JVM_OPTION="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5010"

case "$1" in
  start)
    echo "Starting email-generator…”
    java -jar ${JVM_OPTION} -Djava.io.tmpdir="$CONTRACT_HOME_DIR/cache" $CONTRACT_HOME_DIR/email-generator.jar -d"$CONTRACT_HOME_DIR">> $CONTRACT_HOME_DIR/log &
    echo $! > $CONTRACT_HOME_DIR/pid
    ;;
  stop)
    echo "Stopping email-generato..."
    PID=$(cat $CONTRACT_HOME_DIR/pid)
    kill -9 $PID
    ;;
  restart)
    echo "Stopping email-generato..."
    PID=$(cat $CONTRACT_HOME_DIR/pid)
    kill -9 $PID
    sleep 2;
    echo "Starting email-generato..."
    java -jar ${JVM_OPTION} -Djava.io.tmpdir="$CONTRACT_HOME_DIR/cache" $CONTRACT_HOME_DIR/email-generator.jar -d"$CONTRACT_HOME_DIR">> $CONTRACT_HOME_DIR/log &
    echo $! > $CONTRACT_HOME_DIR/pid
    ;;
  *)
    echo "Usage: $0 {start|stop|restart}"
    ;;
esac

exit 0

