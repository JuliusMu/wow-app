package de.julius.ms_playground

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication
@EnableWebSecurity
class MsPlaygroundApplication

fun main(args: Array<String>) {
    runApplication<MsPlaygroundApplication>(*args)
}
