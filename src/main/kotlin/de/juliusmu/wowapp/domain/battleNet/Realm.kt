package de.juliusmu.wowapp.domain.battleNet

data class Realm(
    val id: Int,
    val key: Key,
    val name: String,
    val slug: String
)