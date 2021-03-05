package de.juliusmu.wowapp.domain.battleNet

import WowCharacter
import WowEquipmentResponse
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class BattleNetService(val webclient: WebClient, val objectMapper: ObjectMapper) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun getWowProfile(authorizedClient: OAuth2AuthorizedClient) = webclient
            .get().uri("https://eu.api.blizzard.com/profile/user/wow?namespace=profile-eu&locale=en_US")
            .attributes(oauth2AuthorizedClient(authorizedClient))
            .retrieve().bodyToMono(String::class.java).block()

    fun getWowCharacter(authorizedClient: OAuth2AuthorizedClient): String? {
        logger.warn(authorizedClient.accessToken.tokenValue)
        val response = webclient
                .get().uri("https://eu.api.blizzard.com/profile/wow/character/anetheron/vulman?namespace=profile-eu&locale=en_US")
                .attributes(oauth2AuthorizedClient(authorizedClient))
                .retrieve().bodyToMono(String::class.java).block()
        val character = objectMapper.readValue(response, WowCharacter::class.java)
        val eqResponse = webclient.get().uri(character.equipment.href + "&locale=en_US")
                .attributes(oauth2AuthorizedClient(authorizedClient))
                .retrieve().bodyToMono(String::class.java).block()
        val equipment = objectMapper.readValue(eqResponse, WowEquipmentResponse::class.java)
        val eqMedia = webclient.get().uri(equipment.equipped_items.get(0).media.href + "&locale=en_US")
                .attributes(oauth2AuthorizedClient(authorizedClient))
                .retrieve().bodyToMono(String::class.java).block()
        return eqResponse
    }

    fun getWowCharacterMedia(authorizedClient: OAuth2AuthorizedClient, characterName: String):String {
        val response = webclient.get().uri("https://eu.api.blizzard.com/profile/wow/character/anetheron/$characterName/character-media?namespace=profile-eu&locale=en_US")
                .attributes(oauth2AuthorizedClient(authorizedClient))
                .retrieve().bodyToMono(String::class.java).block()
        val wowCharacterMediaResponse = objectMapper.readValue(response, WowCharacterMediaResponse::class.java)
        wowCharacterMediaResponse.assets.forEach {
            if (it.key == "main-raw") {
                return it.value
            }
        }
        return "Missing PNG"
    }

}
