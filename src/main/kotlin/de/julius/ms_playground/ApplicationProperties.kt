package de.julius.ms_playground

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.hateoas.config.HypermediaWebClientConfigurer
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder
import org.springframework.security.oauth2.client.registration.ClientRegistration
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction
import org.springframework.security.oauth2.core.AuthorizationGrantType
import org.springframework.web.reactive.function.client.WebClient


@Configuration
class ApplicationProperties {

    @Bean
    fun getRegistration(): ClientRegistrationRepository? {
        val registration: ClientRegistration = ClientRegistration
                .withRegistrationId("battleNet")
                .tokenUri("https://eu.battle.net/oauth/token")
                .clientId("c878040eb3204156813780b93d388040")
                .clientSecret("N8SO6bWb93hpmP014UJPSvIkcguor0Gh")
                .authorizationGrantType(AuthorizationGrantType("authorization_code"))
                .redirectUriTemplate("{baseUrl}/login/oauth2/code/battleNet")
                .userInfoUri("https://eu.battle.net/oauth/userinfo")
                .userNameAttributeName("sub")
                .scope("wow.profile")
                .authorizationUri("https://eu.battle.net/oauth/authorize")
                .build()
        return InMemoryClientRegistrationRepository(registration)
    }


    @Bean
    fun webClient(authorizedClientManager: OAuth2AuthorizedClientManager?, configurer: HypermediaWebClientConfigurer): WebClient {
        val oauth2Client = ServletOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager)
        return hypermediaWebClient(configurer)
                .apply(oauth2Client.oauth2Configuration())
                .build()
    }

    @Bean
    fun hypermediaWebClient(configurer: HypermediaWebClientConfigurer): WebClient.Builder {
        return configurer.registerHypermediaTypes(WebClient.builder())
    }

    @Bean
    fun authorizedClientManager(clientRegistrationRepository: ClientRegistrationRepository?,
                                authorizedClientRepository: OAuth2AuthorizedClientRepository?): OAuth2AuthorizedClientManager? {
        val authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
                .authorizationCode()
                .build()
        val authorizedClientManager = DefaultOAuth2AuthorizedClientManager(
                clientRegistrationRepository, authorizedClientRepository)
        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider)
        return authorizedClientManager
    }

}