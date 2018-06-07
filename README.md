# Platform 6 library

> Library of scripts provided by Amalto to help the development of features on [Platform 6](https://documentation.amalto.com/b2box/dev/).

This repository contains a bunch of templates which can be used to define a specific [Platform 6 route](https://documentation.amalto.com/b2box/dev/user-guide/built-in-services/routes/routes-guide/).

Theses scripts have the `.groovy` file extension and should be stored in the following directories:

 - `${B2BOX_DATA}/resources/templates`
 - `${B2BOX_HOME}/resources/templates`

The <a href="https://freemarker.apache.org/docs/index.html" target="_blank">FreeMarker</a> template engine is used for simple token markup allowing the development of custom templates.

:warning: Although routes are defined using Groovy, the full Platform 6 DSL bindings are not available during route definition.

## Routes templates

- `BaseRoute.groovy`: define a simple route.
- `BaseRestRoute`: create 
- `BaseRouteWithBean.groovy`: 