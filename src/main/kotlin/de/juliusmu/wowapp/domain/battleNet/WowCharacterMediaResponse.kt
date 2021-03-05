package de.juliusmu.wowapp.domain.battleNet

data class WowCharacterMediaResponse(
    val _links: Links,
    val assets: List<Asset>,
    val character: Character
)