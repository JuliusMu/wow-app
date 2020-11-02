package de.julius.ms_playground.web

import de.julius.ms_playground.domain.battleNet.BattleNetService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/api")
class BattleNetController(val battleNetService: BattleNetService) {

    @GetMapping("/profile")
    fun getCharacterData(): String? {
        val response = battleNetService.getWowProfile()
        return response
    }
}