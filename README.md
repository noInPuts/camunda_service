# Camunda Service
This service handles our business proccesses. We are using Camunda Engine library with Java. All of our business processes are written in BPMN. This service is also using SOAP as its external API and RabbitMQ for internal commuication between the services in our application. 

## Busines Processes 
We have 1 Business process written with BPMN.
- Applying for partner as a restaurant 
![Applying for partner as a restaurant BPM](https://raw.githubusercontent.com/noInPuts/camunda_service/main/documents/pictures/applyingforpartnerasrestaurant.png)

## Tech Stack
- Spring boot
- SOAP
- Camunda Engine
- H2 Database
- RabbitMQ