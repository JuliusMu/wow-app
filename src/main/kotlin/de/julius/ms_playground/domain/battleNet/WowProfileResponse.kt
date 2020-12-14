package de.julius.ms_playground.domain.battleNet

data class WowProfileResponse(
        val id: Long,
        val wowAccounts: List<WowAccount>
) {
}