package de.julius.ms_playground.domain.battleNet

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class BattleNetService(val webclient: WebClient) {

    fun getWowProfile() = webclient
            .get().uri("https://eu.api.blizzard.com/profile/user/wow")
            .header("namespace", "profile-eu")
            .retrieve().bodyToMono(String::class.java).block()
}
