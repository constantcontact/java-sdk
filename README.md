Constant Contact JAVA SDK
=========================

## Installation

In order to use the Constant Contact SDK you have to follow these steps:

1) Add the constantcontact.jar library to classpath of your project.
Also add this libraries to classpath of project:

	jackson-annotations-2.1.1.jar
	jackson-core-2.1.1.jar
	jackson-databind-2.1.3.jar
	junit-4.8.1.jar
	easymock-3.1.jar
	httpcore-4.2.1.jar
	httpclient-4.2.1.jar
	commons-logging-1.1.1.jar
	

2) Place your credentials in app.config file.

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

1) In the file you wish to use the SDK include the following code in your file:

 `import com.constantcontact.*;`
<br>
 `import com.constantcontact.components.contacts.*;` 
<br>
`import com.constantcontact.services.*;`
<br>
`import com.constantcontact.auth.*;`
<br>
`import com.constantcontact.util.*;`  

2) Create a ConstantContact object

`ConstantContact constantContact = new ConstantContact(); `                                                                                     
                  
3) Use the functions of the SDK using the created object.   
             
######Example for getting an contact

`Contact contact = constantContact.getContact(int contactId);`                                                      

