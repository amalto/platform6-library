 try {

    ${addBeanAndRegister}
    
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