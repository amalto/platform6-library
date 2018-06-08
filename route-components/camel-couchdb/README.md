## camel-couchdb

https://camel.apache.org/couchdb.html

https://couchdb.apache.org/

#### Installation

1: Download and copy the following files to ${B2BOX_DATA}/lib

https://www.mvnrepository.com/

__platform6 must be restarted to re-read files from this folder.__

- camel-couchdb-2.18.1.jar
- gson-2.8.5.jar
- lightcouch-0.2.0.jar

2: Ensure you have access to an instance of Couchdb 2.1.1 or greater.  You will be required to provide a username and password for this couchdb instance together with it's IP address and port.

Note:  If both platform6 and couchdb are running in the same docker container engine, the container id will be the 'hostname' of the instance __not__ localhost or 127.0.0.1

#### Examples

1: Route Definition To Capture Couchdb Update/Delete Events

```groovy
from("couchdb:http://localhost:5984/test?username=user&password=password")
        .to( "p6cmb://scripts?platform6.request.action=execute&platform6.request.user=couchdb&id=CouchEventHandler" )
        .routeId("myCouchdb2Route")
```
This route will call the platform6 script CouchEventHandler each time an update or delete event occurs on the database called __test__

The headers passed to the script are documented on the component help page.

2: Insert a New Document Into a Database

```groovy
def exchange = [
  body: '{"hello":"world"}',
]

def exMap = camel.endpointExchangeWaitInput('couchdb:http://localhost:5984/test?username=user&password=password', exchange)
```
CouchDbId and CouchDbRev headers are returned in the response exchange Map.