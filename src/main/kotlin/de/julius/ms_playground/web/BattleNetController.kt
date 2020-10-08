package de.julius.ms_playground.web

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/api")
class BattleNetController {

    @GetMapping("/character")
    fun getCharacterData(): HttpStatus {
        return HttpStatus.ACCEPTED
    }
}