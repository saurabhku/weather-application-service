# weather-application-service

<b>Introduction</b><br>
This microservices is responsible for:
1. Using camel to poll a folder in file system to get input list of files
2. Creating a Kafka event with the city list and sending it to a topic
3. Listen to a topic for a event with weather data information
4. To write all the information in a file with name corresponding to current date.

<b>Prerequisites</b><br>
1. To run this service ensure that kafka is running on port 9092 (https://kafka.apache.org/quickstart)
2. Create following topics on Kafka before proceeding
   a. weatherdatainputtopic
   b. weatherdataoutputtopic
   
<b>Invocation</b><br><br>
This service is invoked when a file is copied in to a specific (configurable) directory in file system. The file must contain
list of cities for which weather information is required
Application can be started by in IDE as spring boot application or as a jar.

<b>Complete system diagram:</b><br>
![alt text](https://github.com/saurabhku/weather-application-service/blob/master/images/SeqDiagram.jpg)

<b>Input file Example:</b><br>
{"2643741":"City of London","2988507":"Paris","2964574":"Dublin","4229546":"Washington"}

<br><b>Output generated</b><br>
{2964574={"coord":{"lon":-6.27,"lat":53.34},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],"base":"stations","main":{"temp":11.17,"pressure":1004,"humidity":81,"temp_min":10.56,"temp_max":11.67},"visibility":10000,"wind":{"speed":7.7,"deg":270},"clouds":{"all":75},"dt":1559756114,"sys":{"type":1,"id":1565,"message":0.0046,"country":"IE","sunrise":1559707257,"sunset":1559767583},"timezone":3600,"id":2964574,"name":"Dublin","cod":200}, 2643741={"coord":{"lon":-0.09,"lat":51.51},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"base":"stations","main":{"temp":15.98,"pressure":1007,"humidity":55,"temp_min":14,"temp_max":17.78},"visibility":10000,"wind":{"speed":4.6,"deg":200},"clouds":{"all":100},"dt":1559756291,"sys":{"type":1,"id":1414,"message":0.0085,"country":"GB","sunrise":1559706386,"sunset":1559765487},"timezone":3600,"id":2643741,"name":"City of London","cod":200}, 4229546={"coord":{"lon":-82.74,"lat":33.74},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"base":"stations","main":{"temp":28.43,"pressure":1017,"humidity":66,"temp_min":27.22,"temp_max":31.11},"visibility":16093,"wind":{"speed":2.1,"deg":240},"clouds":{"all":1},"dt":1559756310,"sys":{"type":1,"id":3930,"message":0.0058,"country":"US","sunrise":1559730042,"sunset":1559781508},"timezone":-14400,"id":4229546,"name":"Washington","cod":200}, 2988507={"coord":{"lon":2.35,"lat":48.85},"weather":[{"id":502,"main":"Rain","description":"heavy intensity rain","icon":"10d"},{"id":701,"main":"Mist","description":"mist","icon":"50d"}],"base":"stations","main":{"temp":11.3,"pressure":1008,"humidity":93,"temp_min":10,"temp_max":12.22},"visibility":7000,"wind":{"speed":5.7,"deg":280},"rain":{"1h":6.35},"clouds":{"all":100},"dt":1559755919,"sys":{"type":1,"id":6550,"message":0.0066,"country":"FR","sunrise":1559706580,"sunset":1559764122},"timezone":7200,"id":2988507,"name":"Paris","cod":200}}
