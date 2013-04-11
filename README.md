Constant Contact JAVA SDK
=========================

## Installation

In order to use the Constant Contact SDK please follow these steps:

1) Add the following libraries to the classpath of your project:

	constantcontact-2.0.jar
	jackson-annotations-2.1.1.jar
	jackson-core-2.1.1.jar
	jackson-databind-2.1.3.jar
	constant-contact-httpclient-4.2.3.jar

2) Place your credentials in the app.config file as follows:

`APIKey=APIkey`
<br>
`ConsumerSecret=ConsumerSecret`
<br>
`Password=password`
<br>
`Username=username`
<br>
`RedirectURL=RedirectURL`

## Usage

1) In the file you wish to use the SDK include the following code:

 `import com.constantcontact.*;`
<br>
 `import com.constantcontact.components.contacts.*;` 
<br>
`import com.constantcontact.services.*;`
<br>
`import com.constantcontact.authentication.*;`
<br>
`import com.constantcontact.util.*;`  


2) Create a ConstantContact object

Use the following constructor to use the credentials defined in the app.config file:

`ConstantContact constantContact = new ConstantContact(); ` 


Otherwise the credentials can be specified as constructor parameters:

`ConstantContact constantContact = new ConstantContact("username", "password", "apiKey", "redirectUrl");`       
                                                          
                  
3) Begin using the SDK functionality using the ConstantContact object.   
             
######Example for getting an contact

`Contact contact = constantContact.getContact(int contactId);`  

######Example for getting contact list
       
`ResultSet<Contact> contactList =  constantContact.getContacts();` 


4)Usage in Android

In order to use the Constant Contact SDK for Android you have to include constant contact SDK sources and libraries.



                                             

