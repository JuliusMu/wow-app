package de.julius.ms_playground

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.hateoas.config.EnableHypermediaSupport
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication
@EnableWebSecurity
@EnableHypermediaSupport(type = [EnableHypermediaSupport.HypermediaType.HAL])
class MsPlaygroundApplication

fun main(args: Array<String>) {
    runApplication<MsPlaygroundApplication>(*args)
}
