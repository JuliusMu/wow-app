package de.julius.ms_playground.domain.battleNet

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class BattleNetService(val webclient: WebClient) {

    fun getWowProfile(authorizedClient: OAuth2AuthorizedClient) = webclient
            .get().uri("https://eu.api.blizzard.com/profile/user/wow?namespace=profile-eu&locale=en_US")
            .attributes(oauth2AuthorizedClient(authorizedClient))
            .retrieve().bodyToMono(String::class.java).block()
}
