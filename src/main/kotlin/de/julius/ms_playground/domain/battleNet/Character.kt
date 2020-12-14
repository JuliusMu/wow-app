package de.julius.ms_playground.domain.battleNet

data class Character(
    val id: Int,
    val key: Key,
    val name: String,
    val realm: Realm
)