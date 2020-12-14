package de.julius.ms_playground.domain.battleNet

data class WowCharacterMediaResponse(
    val _links: Links,
    val assets: List<Asset>,
    val character: Character
)