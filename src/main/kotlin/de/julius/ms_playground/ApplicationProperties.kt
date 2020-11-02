package de.julius.ms_playground

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction
import org.springframework.web.reactive.function.client.WebClient


@Configuration
class ApplicationProperties {

    /*@Bean("CustomClientRegistration")
    fun getRegistration(): ReactiveClientRegistrationRepository? {
        val registration: ClientRegistration = ClientRegistration
                .withRegistrationId("battleNet")
                .tokenUri("https://eu.battle.net/oauth/token")
                .clientId("c878040eb3204156813780b93d388040")
                .clientSecret("c878040eb3204156813780b93d388040")
                .authorizationGrantType(AuthorizationGrantType("authorization_code"))
                .redirectUri("{baseUrl}/login/oauth2/code/battleNet")
                .userInfoUri("https://eu.battle.net/oauth/userinfo")
                .userNameAttributeName("battletag")
                .scope("wow.profile")
                .authorizationUri("https://eu.battle.net/oauth/authorize")
                .build()
        return InMemoryReactiveClientRegistrationRepository(registration)
    }*/


    /*@Bean
    fun webClient(
            clientRegistrations: ReactiveClientRegistrationRepository,
            authorizedClients: ServerOAuth2AuthorizedClientRepository?): WebClient? {
        val oauth = ServerOAuth2AuthorizedClientExchangeFilterFunction(
                clientRegistrations,
                authorizedClients)
        oauth.setDefaultOAuth2AuthorizedClient(true)
        return WebClient.builder()
                .filter(oauth)
                .build()


    }*/
    @Bean
    fun webClient(authorizedClientManager: OAuth2AuthorizedClientManager?): WebClient {
        val oauth2Client = ServletOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager)
        return WebClient.builder()
                .apply(oauth2Client.oauth2Configuration())
                .build()
    }

    @Bean
    fun authorizedClientManager(clientRegistrationRepository: ClientRegistrationRepository?,
                                authorizedClientRepository: OAuth2AuthorizedClientRepository?): OAuth2AuthorizedClientManager? {
        val authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
                .authorizationCode()
                .refreshToken()
                .clientCredentials()
                .password()
                .build()
        val authorizedClientManager = DefaultOAuth2AuthorizedClientManager(
                clientRegistrationRepository, authorizedClientRepository)
        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider)
        return authorizedClientManager
    }

}