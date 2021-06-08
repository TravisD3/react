export JAVA_HOME=/usr/lib/jvm/jdk-12.0.1
export PATH=$JAVA_HOME/bin:$PATH

#java -jar bTradeServer-2.0.jar --spring.config.location=classpath:application.$properties,file:///home/ec2-user/bTrade2.0/server/application.yml
java -jar bTradeServer3-1.0.jar --spring.config.location=classpath:/application.properties
 
#com.btrade.server.BTradeServerApplication
