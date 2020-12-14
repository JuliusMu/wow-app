package de.julius.ms_playground.domain.battleNet

import WowCharacter
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.hateoas.client.Hop
import org.springframework.hateoas.client.Traverson
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class BattleNetService(val webclient: WebClient, val objectMapper: ObjectMapper) {

    fun getWowProfile(authorizedClient: OAuth2AuthorizedClient) = webclient
            .get().uri("https://eu.api.blizzard.com/profile/user/wow?namespace=profile-eu&locale=en_US")
            .attributes(oauth2AuthorizedClient(authorizedClient))
            .retrieve().bodyToMono(String::class.java).block()

    fun getWowCharacter(authorizedClient: OAuth2AuthorizedClient): String? {
        val response = webclient
                .get().uri("https://eu.api.blizzard.com/profile/wow/character/anetheron/vulman?namespace=profile-eu&locale=en_US")
                .attributes(oauth2AuthorizedClient(authorizedClient))
                .retrieve().bodyToMono(String::class.java).block()
        val character = objectMapper.readValue(response, WowCharacter::class.java)
        val eqResponse = webclient.get().uri(character.equipment.href, mapOf("locale" to "en_US"))
                .attributes(oauth2AuthorizedClient(authorizedClient))
                .retrieve().bodyToMono(String::class.java).block()
        return eqResponse
    }

}
