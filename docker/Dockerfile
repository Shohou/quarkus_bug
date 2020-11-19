## FINAL IMAGE ##
FROM openjdk:11-jre-slim

ARG RUN_JAVA_VERSION=1.3.8

ENV BASE_DIR="/opt/code-with-quarkus" \
    HOME="${BASE_DIR}" \
    TERM=xterm

# Install java and the run-java script
# Also set up permissions for user `1001`
RUN apt-get update -qq \
    && apt-get install -qqy --no-install-recommends less curl \
    && rm -rf /var/lib/apt/lists/* \
    && mkdir ${BASE_DIR} \
    && chown 1001 ${BASE_DIR} \
    && chmod "g+rwX" ${BASE_DIR} \
    && chown 1001:root ${BASE_DIR} \
    && curl https://repo1.maven.org/maven2/io/fabric8/run-java-sh/${RUN_JAVA_VERSION}/run-java-sh-${RUN_JAVA_VERSION}-sh.sh -o ${BASE_DIR}/run-java.sh \
    && chown 1001 ${BASE_DIR}/run-java.sh \
    && chmod 540 ${BASE_DIR}/run-java.sh \
    && echo "securerandom.source=file:/dev/urandom" >> ${JAVA_HOME}/lib/security/java.security

# Configure the JAVA_OPTIONS, you can add -XshowSettings:vm to also display the heap size.
ENV JAVA_OPTIONS="-Djava.util.logging.manager=org.jboss.logmanager.LogManager -XshowSettings:vm -XX:NativeMemoryTracking=summary" \
    JAVA_MAX_MEM_RATIO=75 \
    JAVA_INIT_MEM_RATIO=75

COPY target/lib/* ${BASE_DIR}/lib/
COPY target/*-runner.jar ${BASE_DIR}/app.jar

USER 1001

ENTRYPOINT exec "${BASE_DIR}/run-java.sh"
