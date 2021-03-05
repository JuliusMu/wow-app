package de.juliusmu.wowapp.domain.battleNet

data class Character(
    val id: Int,
    val key: Key,
    val name: String,
    val realm: Realm
)