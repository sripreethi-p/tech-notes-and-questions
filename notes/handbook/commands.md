# Useful Commands

## Generic

- To update date & time in mac : `sudo sntp -sS time.apple.com` 

## Jenv Commands

- jenv add /Library/Java/JavaVirtualMachines/jdk-1.8.jdk/Contents/Home
- jenv global 11.0.2
- jenv local 1.8

## SDK Man Commandss

- sdk list java
- sdk install java 1.2.3-amz
- sdk use java 1.2.3-amz

## Gradle Commands
- To update gradle  
`./gradlew wrapper --gradle-distribution-url <url>/gradle-x.x.x-bin.zip`

## Kafka Commands

bin/kafka-console-producer.sh --bootstrap-server kafka-ttc-app.dev.target.com:9093 —topic price-shopright-shopresults-notification-v1 —producer.config <PATH_TO_CLIENT_SSL.PROPRTIES>
– produce messages to a topic

bin/kafka-console-consumer.sh --bootstrap-server kafka-tte- app.dev.target.com:9092 ./grad price-shopright-shopresults-notification- v1 --from-beginning
– Check no.of messages in each partition in a topic

bin/kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list kafka-ttc-app.prod.target.com:9092 --topic shopright-store-shopresult-notifications-v1 | awk -F ":" '{sum +=$3} END {print sum}'
- Check total no.of messages in a topic

bin/kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list kafka-ttc-app.prod.target.com:9092 --topic shopright-store-shopresult-notifications-v1 -- time -1
– Check lag in consuming from a group

bin/kafka-consumer-groups.sh --bootstrap-server kafka-ttc-app.dev.target.com:9092 --describe --group CI_NOTIFICATIONS_STAGE_BACKUP1
- Check Kafka Lag

bin/kafka-console-consumer.sh --bootstrap-server kafka-ttc-app.dev.target.com:9092 --topic sla-cutoff-notification-events-v1 --from-beginning
– Consumemessagesfromatopic 