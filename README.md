Constant Contact JAVA SDK
=========================

[![Build Status](https://travis-ci.org/constantcontact/java-sdk.svg)](https://travis-ci.org/constantcontact/java-sdk)

## Installation

In order to use the Constant Contact SDK please follow these steps:

1) This project builds with Apache Maven. Running maven clean install will build and test the source and install its artifacts and dependencies into your maven repository. At this point, you can add the Constant Contact SDK as a dependency to other projects. If you do not wish to build with Maven, consult the pom.xml file to examine the dependencies the Constant Contact SDK has. For example, it requires Jackson for JSON processing.

## Documentation

The Javadoc is hosted at http://constantcontact.github.io/java-sdk

API Documentation is located at http://developer.constantcontact.com/docs/developer-guides/api-documentation-index.html

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




                                             

