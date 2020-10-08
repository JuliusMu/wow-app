package de.julius.ms_playground

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MsPlaygroundApplication

fun main(args: Array<String>) {
	runApplication<MsPlaygroundApplication>(*args)
}
