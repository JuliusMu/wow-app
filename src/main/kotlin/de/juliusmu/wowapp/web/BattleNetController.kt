package de.juliusmu.wowapp.web

import de.juliusmu.wowapp.domain.battleNet.BattleNetService
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class BattleNetController(val battleNetService: BattleNetService) {

    @GetMapping("/profile")
    fun getProfile(@RegisteredOAuth2AuthorizedClient("battleNet") authorizedClient: OAuth2AuthorizedClient): String? {
        val response = battleNetService.getWowProfile(authorizedClient)
        return response
    }

    @GetMapping("/character/{characterName}")
    fun getCharacter(@RegisteredOAuth2AuthorizedClient("battleNet") authorizedClient: OAuth2AuthorizedClient, @PathVariable characterName: String): String? {
        val response = battleNetService.getWowCharacterMedia(authorizedClient,characterName)
        if (response != null) {
            return "<img src=\"$response\">"
        }
        else{
            return "AAAAAHHH!!"
        }
    }
}