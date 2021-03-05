package de.juliusmu.wowapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.hateoas.config.EnableHypermediaSupport
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication
@EnableWebSecurity
@EnableHypermediaSupport(type = [EnableHypermediaSupport.HypermediaType.HAL])
class WowApp

fun main(args: Array<String>) {
    runApplication<WowApp>(*args)
}
