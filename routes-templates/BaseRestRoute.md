## Purpose



## Template

```groovy
try {

camel.getCtx().addRoutes(new RouteBuilder() {
    def void configure() {
        ${addRoutes}
    }
})

pause()

} 
finally {

${destroyRoutes}

}
```

## Variables

`${addRoutes}` 

```groovy
rest( '/public/say' )
    .get( '/hello' ).to( 'p6cmb://scripts?platform6.request.action=execute&platform6.request.user=iot&id=RestHello' ).id('RestOne');
      
rest( '/public/say' )
    .get( '/bye' ).to( 'direct:bye' ).id('RestTwo');
      
rest( '/public/say' )
    .post( '/tankalert').consumes( 'application/json' ).produces( 'application/json' ).to( 'p6cmb://scripts?platform6.request.action=execute&platform6.request.user=iot&id=RestTank' ).id('RestThree');

from( 'direct:bye' )
    .transform().constant( 'Bye World' ).routeId('RestFour');
```

`${destroyRoutes}`

```groovy
camel.destroyRoute('RestOne')
camel.destroyRoute('RestTwo')
camel.destroyRoute('RestThree')
camel.destroyRoute('RestFour')
```


 
