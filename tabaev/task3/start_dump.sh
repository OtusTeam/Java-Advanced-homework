time /lib/jvm/jdk-17-oracle-x64/bin/java \
-Xshare:dump -XX:SharedClassListFile=app_classes.lst -XX:SharedArchiveFile=app_cds.jsa \
-Xlog:class+load:file=app_cds_dump.log \
-XX:TieredStopAtLevel=1 -Dspring.output.ansi.enabled=always \
-Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true \
-Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true \
-Dfile.encoding=UTF-8 \
-jar ./target/task3-0.0.1-SNAPSHOT.jar
