# Constant Contact Java SDK
Java and Android library for accessing the Constant Contact API. Based on the [Retrofit](http://square.github.io/retrofit/) framework.

## Usage
After creating an account [through Mashery](https://constantcontact.mashery.com/), and using your API key to get an access token for an 
account, you can start by creating the ```CCApi2``` object, and make the call you need through the appropriate service.

All of the calls respond with Retrofit ```Call``` objects, which can be consumed synchronously (```execute```) or 
asynchronously (```enqueue```). Full documentation of the ```Call``` class can be found [here](https://square.github.io/retrofit/2
.x/retrofit/retrofit2/Call.html/).

Each service is fully documented in Javadoc with full explanations of each parameter.

#### Get Account Information (Synchronous Example)
```java
CCApi2 _api = new CCApi2("your_api_key", "your_access_token");
try {
    AccountSummaryInformation accountSummary = _api.getAccountService().getAccountSummaryInformation().execute();
} catch (IOException e) {
    // Handle exception
}
```

#### Get Contact Collection (Asynchronous Example)
```java
CCApi2 _api = new CCApi2("your_api_key", "your_access_token");
Callback<Paged<Contact>> callback = new Callback<Paged<Contact>>() {
    @Override
    public void onResponse(Response<Paged<Contact>> response) {
        List<Contact> contacts = response.body().getResults();
    }
    
    @Override
    public void onFailure(Throwable t) {
    }
}
_api.getContactService().getContacts(50, ContactStatus.ACTIVE).enqueue(callback);
```

## Installation
The JAR is available on [JCenter](https://bintray.com/bintray/jcenter), or you can download manually from 
the [releases page](https://github.com/constantcontact/java-sdk/releases).

### Gradle
```groovy
compile 'com.constantcontact:java-sdk:5.0.1'
```

### Maven
```xml
<dependencies>
    <dependency>
        <groupId>com.constantcontact</groupId>
        <artifactId>java-sdk</artifactId>
        <version>5.0.1</version>
    </dependency>
</dependencies>
```

## License
    Copyright (c) 2016, Constant Contact, Inc.
    All rights reserved.
    
    Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
    1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
    2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
    3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
    