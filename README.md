# Constant Contact Java SDK [![Build Status](https://travis-ci.org/constantcontact/java-sdk.svg?branch=master)](https://travis-ci.org/constantcontact/java-sdk) [ ![Download](https://api.bintray.com/packages/constantcontact/maven/java-sdk/images/download.svg) ](https://bintray.com/constantcontact/maven/java-sdk/_latestVersion)
Java and Android library for accessing the Constant Contact API. Based on the [Retrofit](http://square.github.io/retrofit/) framework.

## Usage
You'll need an API key and access token to use the SDK. Do so by creating a developer account [here](https://constantcontact.mashery.com/member/register), then register an app to generate an API key and access token for an account.

Then, start by creating the ```CCApi2``` object, and make the call you need through the appropriate service. Learn more about signing up 
for a developer account [here](https://developer.constantcontact.com/api-keys.html).

All of the calls respond with Retrofit ```Call``` objects, which can be consumed synchronously (```execute```) or 
asynchronously (```enqueue```). Full documentation of the ```Call``` class can be found [here](https://square.github.io/retrofit/2.x/retrofit/retrofit2/Call.html).

Each service is fully documented in the [Javadoc](http://constantcontact.github.io/java-sdk/) with full explanations of each parameter.

#### Get Account Information (Synchronous Example)
```java
CCApi2 api = new CCApi2("your_api_key", "your_access_token");
try {
    AccountSummaryInformation accountSummary = api.getAccountService()
                                                  .getAccountSummaryInformation()
                                                  .execute()
                                                  .body();
} catch (IOException e) {
    // Handle exception
}
```

#### Get Contact Collection (Asynchronous Example)
```java
CCApi2 api = new CCApi2("your_api_key", "your_access_token");
Callback<Paged<Contact>> callback = new Callback<Paged<Contact>>() {
    @Override
    public void onResponse(Response<Paged<Contact>> response) {
        List<Contact> contacts = response.body().getResults();
    }
    
    @Override
    public void onFailure(Throwable t) {
    }
}
api.getContactService().getContacts(50, ContactStatus.ACTIVE).enqueue(callback);
```

## Installation
The JAR is available on [JCenter](https://bintray.com/bintray/jcenter), or you can download manually from 
the [releases page](https://github.com/constantcontact/java-sdk/releases). Note, if you download manually,
you will also need to download the Components JAR and include it in your build file.

### Artifacts
The base library is the `java-sdk` artifact. If you use RxJava there are two artifacts available depending on the version:
`java-sdk-rx` for RxJava 1 users and `java-sdk-rx2` for RxJava 2 users (all calls return `Observable`).

#### Gradle - Release
```groovy
compile 'com.constantcontact:java-sdk:5.1.8'
```
#### Gradle - Snapshot
```groovy
allprojects {
    repositories {
        maven("https://oss.jfrog.org/artifactory/oss-snapshot-local/")
    }
}
compile 'com.constantcontact:java-sdk:X.X.X-SNAPSHOT'
```

#### Maven
```xml
<dependencies>
    <dependency>
        <groupId>com.constantcontact</groupId>
        <artifactId>java-sdk</artifactId>
        <version>5.1.8</version>
    </dependency>
</dependencies>
```

### Release Process
There's an automated build process set up for the various build types that can occur, based on where code is pushed or merged.

1. When a PR is opened, or pushed to, [Travis CI](https://travis-ci.org/constantcontact/java-sdk) will run a PR build which then reports the status back to the 
GitHub PR. If any unit tests fail, the PR will not be mergable until they are fixed.
2. When a PR is merged to master, or if there's a push to master, [Travis CI](https://travis-ci.org/constantcontact/java-sdk) will run a regular build with test,
and then automatically deploy a SNAPSHOT build to https://oss.jfrog.org (a.k.a. OJO). These builds can be found
[here](https://oss.jfrog.org/artifactory/oss-snapshot-local/com/constantcontact/).
3. When a tag is applied to a commit that follows the format '#.#.#', 
[Travis CI](https://travis-ci.org/constantcontact/java-sdk) will run a release build, and then upload to the 
[Bintray](https://bintray.com/constantcontact/maven) maven repo (which also automatically deploys to JCenter),
as well as creates a draft release [here](https://github.com/constantcontact/java-sdk/releases). 
    1. In order for the Bintray release to become visible, the uploads must be made public. The Bintray maven
    dashboard page will have a node that there are 16 or so unreleased files with a publish link. Click publish
    to release it.
    2. Likewise, the GitHub release is generated as a draft. Edit the draft, add notes about the changes and
    click publish to make it visible to developers.

## License
```
Copyright (c) 2016, Constant Contact, Inc.
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted 
provided that the following conditions are met:
1. Redistributions of source code must retain the above copyright notice, this list of conditions 
and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright notice, this list of 
conditions and the following disclaimer in the documentation and/or other materials provided 
with the distribution.
3. Neither the name of the copyright holder nor the names of its contributors may be used to 
endorse or promote products derived from this software without specific prior written permission.
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR 
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY 
AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR 
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, 
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER 
IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
```
    
