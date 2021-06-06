# Payment API to transfer corporate payments

This Payment API has the following operations
1. Transfer money between customer's own accounts
2. Transfer money between registered beneficiary account
3. Ad-hoc transfer to a domestic bank account
4. Get status of a fund transfer
5. Initiates reversal of a transfer in case of any issues
6. Retrives the Account balance
7. Retrives the transaction list with ( Specific date range, Transaction type ( credit, debit ) )

# Application Flow 

![image](https://user-images.githubusercontent.com/24898025/120914546-6632c580-c6d1-11eb-9e91-836e987ea5da.png)


### Technology/Tools/Approach

* JAVA 8
* Spring Boot 2.4.0
* Spring REST API
* In-memory database H2
* ORM Framework - Srping Data JPA
* Mapstruct API - Java bean mappings
* Spring Cloud - Fiegnclient
* Spring Boot Actuator
* Integration Test - TestRestRemplate Client
* API documentation - SpringFox Swagger



### User Guidance

This is Maven based java project. Having two modules

1. Payment-service - Responsible for 

    * Receives the payment from customers
    * Persist the payment information
    * Perform the first level authentication checks like file format, signatures & value date
    * Identify the backend to be sent based on the routing rule 
    * Forwards the payment to respective backend    <br />
    
2. Payment-processor

    * Perform the Account, Balance & limit check
    * Tranfer the funds
    * Generates the feedback message

### Building and Running it locally
	
   * You can clone the click-to-pay project by cloning from below git command  <br />	
   
	git clone https://github.com/sayamar/click-to-pay.git  <br />
   
   * You can build an executable jar-files ( payment-service & payment-processor ) by executing the following command
   
	mvn clean package
   
   * Run the jar file by using java command with two diffrent ports for ex: 8081, 8082
   
	java -jar -Dport=8081 payment-service-0.0.1-SNAPSHOT.jar 
   
	java -jar -Dport=8082 payment-processor-0.0.1-SNAPSHOT.jar
   		  
### API Documentation by Swagger

	http://localhost:8081/swagger-ui.html 
	http://localhost:8083/swagger-ui.html
   
### Integration Test by Using TestRestTemplate

	Integration Tests perfomed by using TestRestTemplate

### Improvements



