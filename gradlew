#!/usr/bin/env sh

# Attempt to set APP_HOME
# Resolve links: \$0 may be a link
PRG="\$0"
while [ -h "\$PRG" ] ; do
    ls=`ls -ld "$PRG"`
    link=`expr "$ls" : '.*-> \(.*\)$'`
    if expr "\$link" : '/.*' > /dev/null; then
        PRG="\$link"
    else
        PRG=`dirname "$PRG"`/"\$link"
    fi
done
SAVED="`pwd`"
cd "`dirname \"$PRG\"`/" >/dev/null
APP_HOME="`pwd`"
cd "\$SAVED" >/dev/null

APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS=""

# Use the maximum available, or set max via CLASSPATH
CLASSPATH=\$APP_HOME/gradle/wrapper/gradle-wrapper.jar

exec java \$DEFAULT_JVM_OPTS -classpath "CLASSPATH" org.gradle.wrapper.GradleWrapperMain "@"
