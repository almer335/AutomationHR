package com.automation.core;

import org.springframework.context.annotation.*;

/**
 *
 * @Configuration indica que esta clase es de configuración para Spring.
 * @PropertySource indica los archivos en donde se encuentran las properties a levantar, ver que en la misma se resuelven los parametros de ejecución.
 * @ComponentScan indica a partir de qué package scaneará Spring al levantar en busca de clases con @Component, @Repository, @Service, etc.
 * @Lazy si en la clase de configuración definimos un Bean como "Lazy",cuando lo autowairemos acá tambien debemos indicar que es "Lazy".
 *
 **/
@Configuration
@PropertySource(value = {"classpath:properties/environments/${environment}.properties",
        "classpath:properties/common/default.properties", "classpath:properties/defaults/default.properties"}, encoding = "UTF-8")
@ComponentScan(basePackages = "com.automation")
@Lazy
public class SpringConfiguration {

}
