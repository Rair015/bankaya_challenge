# bankaya_challenge | Pokeapiconsumer
# Description
A SOAP contract-first web service implemented using Spring-WS, Maven written in java, this service consumes data from PokeAPI REST and feeds back with SOAP standards to the user making requests in pokeapiconsumer, aditionally, has a log of requests made and to which methods saved to a H2 db.

# Tools Used
*Intellij IDE - for development
*SOAP UI - to perform requests

# How to Run
Being a contract-first the xml requests and responses definition come first and from them the Java classes are derived, so first thing is to execute 'mvn clean install' in order to get the necessary java classes generated to be able to run the project, having done that run the main method a visit 'http://localhost:8080/ws/pokemon.wsdl' where the wsdl fiel will be shown which mean the service is running, take that url and used it for create a SOAP UI project, make sure to select 'Create sample requests for all operations', now you can perform requests ato the service.

# H2 Database
![image](https://github.com/user-attachments/assets/40cce666-79b4-4135-b58c-6298e00e9a31)

Use the image above to login to the db, visiting 'http://localhost:8080/h2-console'

