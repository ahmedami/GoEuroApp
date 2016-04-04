# GoApp
Make a Prisestance layar based on CSV.

## Architecture
![alt tag](https://github.com/ahmedami/GoEuroApp/blob/master/Architecture.png)

### DAO Layer
for saving and searching in CSV file,Also it contain CheckExistance Class that check if there is file or not.

###Service Layer
It containing Transaction that hold every transaction with DAO Layer.
Also it contain RESTful connection to connect to GoEuro API and get response from it.

###Facade Layer 
Every method from it may use many methods from Service Layer , it's for simplicity.

###DTO
Containing Place Dto and Geo Position Dto that represent the return object from Web Service .
Also it contain Response Dto that hold all the System messages that will appear to user .

###Pojo
Contain the object that will presist to csv file .

###CustomException
It's a custom Exception to keep exception handling as simple as possible.

###Test
It just holding the Entry Method for the system "main method".

##How To Run
From GoApp folder there is a jar file called GoApp.jar.
- open your terminal.
- go to GoApp folder.
-  type that command from you terminal ' java -jar GoApp.jar "placeName" '.

also you can use the absolute path ,it's up to you.
