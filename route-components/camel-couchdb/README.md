# Camel CouchDB

Some helpful links:

- https://camel.apache.org/couchdb.html
- https://couchdb.apache.org/

## Installation

1. Download files from https://www.mvnrepository.com/ and copy the following files to `${P6_DATA}/lib`.

- `camel-couchdb-2.24.2.jar`
- `gson-2.8.5.jar`
- `lightcouch-0.2.0.jar`

<b>Note: Platform 6 must be restarted to re-read files from this folder!</b>

2. Ensure you have access to an instance of CouchDB 2.1.1 or greater.
You will be required to provide a username and password for this CouchDB instance together with it's IP address and port.

> If both Platform 6 and CouchDB are running in the same Docker container engine, the container `id` will be the `hostname` of the instance __not__ `localhost` or `127.0.0.1`.

:warning: If you use CouchDB 2.3 or greater you must use <b>lightcouch-0.2.5.jar</b>

## Examples

1. Route definition to capture CouchDB update/delete events.

```groovy
from("couchdb:http://localhost:5984/test?username=user&password=password")
  .to( "p6cmb://scripts?platform6.request.action=execute&id=CouchEventHandler" )
  .routeId("myCouchdb2Route")
```
This route will call the Platform 6 script `CouchEventHandler` each time an update or delete event occurs on the database called `test`.

The headers passed to the script are documented on the [component help page](https://camel.apache.org/couchdb.html).

2. Insert a new document into a database.

```groovy
def exchange = [
  body: '{"hello":"world"}',
]

def exMap = camel.endpointExchangeWaitInput('couchdb:http://localhost:5984/test?username=user&password=password', exchange)
```

`CouchDbId` and `CouchDbRev` headers are returned in the response exchange Map.
