# weather-application-service

Introduction
This microservices is responsible for:
1. Using camel to poll a folder in file system to get input list of files
2. Creating a Kafka event with the city list and sending it to a topic
3. Listen to a topic for a event with weather data information
4. To write all the information in a file with name corresponding to current date.

Prerequisites
1. To run this service ensure that kafka is running on port 9092
2. Create following topics on Kafka before proceeding
   a. weatherdatainputtopic
   b. weatherdataoutputtopic
   
Invocation
This service is invoked when a file is copied in to a specific (configurable) directory in file system. The file must contain
list of cities for which weather information is required
Application can be started by in IDE as spring boot application or as a jar.

Complete system diagram:
Screenshot:
![alt text](https://github.com/saurabhku/weather-application-service/blob/master/images/SeqDiagram.jpg)
