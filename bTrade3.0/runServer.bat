SET JAVA_HOME=C:\Program Files\Java\jdk-12.0.2
SET PATH=%JAVA_HOME%\bin;%PATH%
cd server
java -jar target\bTradeServer3-1.0.jar --spring.config.location=classpath:/application.properties
