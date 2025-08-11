#!/bin/sh

# Fail on a single failed command
set -eo pipefail

appDir=${DEPLOY_DIR:-/deployments}
echo "Checking *.war in $appDir"
if [ -d ${appDir} ]; then
  target="/opt/tomcat/webapps"
  for i in ${appDir}/*.war; do
     file=$(basename ${i})
     echo "Linking $i --> $target"
     if [ -f "${target}/${file}" ]; then
         rm "${target}/${file}"
     fi
     dir=$(basename ${i} .war)
     if [ x${dir} != x ] && [ -d "${target}/${dir}" ]; then
         rm -r "$target/${dir}"
     fi
     ln -s ${i} "${target}/${file}"
  done
fi

# Use faster (though more unsecure) random number generator
export CATALINA_OPTS="${CATALINA_OPTS} $(/deployments/run-java.sh options) -Djava.security.egd=file:/dev/./urandom"

/opt/tomcat/bin/catalina.sh run
