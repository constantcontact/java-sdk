Constant Contact JAVA SDK
=========================

## Installation

In order to use the Constant Contact SDK please follow these steps:

1) Add the following libraries to the classpath of your project:

	constantcontact-2.0.jar
	jackson-annotations-2.1.1.jar
	jackson-core-2.1.1.jar
	jackson-databind-2.1.3.jar

2) Installation for Android projects

In order to use the Constant Contact SDK for Android you have to include
 constantcontact-2.0.jar and jackson dependencies presented at 1) in your Android Project.

3) For Eclipse Android development if NoDefClassFoundError is raised then:
	
	a) make sure that the dependency libraries are located in libs/ directory;
	b) Go to Project Properties -> Java Build Path -> Order and Export, and move the 
	dependency jar libraries to the top of the list.

## Usage

1) In the file you wish to use the SDK include the following code:

import com.constantcontact.ConstantContact;


2) Create a ConstantContact object

`ConstantContact constantContact = new ConstantContact("<apiKey>", "<accessToken>");`  

The API key represents the Application Key provided by Constant Contact for a specific application.
The access token is obtained by performing the Constant Contact Authentication process.     
                                                          
                  
3) Begin using the SDK functionality using the ConstantContact object.   
             
######Example for getting an contact

`Contact contact = constantContact.getContact(int contactId);`  

######Example for getting contact list
       
`ResultSet<Contact> contactList =  constantContact.getContacts();` 




                                             

