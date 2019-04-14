#FROM anapsix/alpine-java:8_server-jre_unlimited
FROM xiancloud/alpine-jre8:1.0
RUN mkdir -p /data/workspace
COPY xian_runtime /data/workspace/xian_runtime

ENV XIAN_ENV dockerTest