data class WowCharacter(
    val _links: Links,
    val achievement_points: Int,
    val achievements: Achievements,
    val achievements_statistics: AchievementsStatistics,
    val active_spec: ActiveSpec,
    val appearance: Appearance,
    val average_item_level: Int,
    val character_class: CharacterClass,
    val collections: Collections,
    val covenant_progress: CovenantProgress,
    val encounters: Encounters,
    val equipment: Equipment,
    val equipped_item_level: Int,
    val experience: Int,
    val faction: Faction,
    val gender: Gender,
    val guild: Guild,
    val id: Int,
    val last_login_timestamp: Long,
    val level: Int,
    val media: Media,
    val mythic_keystone_profile: MythicKeystoneProfile,
    val name: String,
    val professions: Professions,
    val pvp_summary: PvpSummary,
    val quests: Quests,
    val race: Race,
    val realm: RealmX,
    val reputations: Reputations,
    val specializations: Specializations,
    val statistics: Statistics,
    val titles: Titles
)

data class Links(
    val self: Self
)

data class Achievements(
    val href: String
)

data class AchievementsStatistics(
    val href: String
)

data class ActiveSpec(
    val id: Int,
    val key: Key,
    val name: String
)

data class Appearance(
    val href: String
)

data class CharacterClass(
    val id: Int,
    val key: Key,
    val name: String
)

data class Collections(
    val href: String
)

data class CovenantProgress(
    val chosen_covenant: ChosenCovenant,
    val renown_level: Int,
    val soulbinds: Soulbinds
)

data class Encounters(
    val href: String
)

data class Equipment(
    val href: String
)

data class Faction(
    val name: String,
    val type: String
)

data class Gender(
    val name: String,
    val type: String
)

data class Guild(
    val faction: FactionX,
    val id: Int,
    val key: Key,
    val name: String,
    val realm: Realm
)

data class Media(
    val href: String
)

data class MythicKeystoneProfile(
    val href: String
)

data class Professions(
    val href: String
)

data class PvpSummary(
    val href: String
)

data class Quests(
    val href: String
)

data class Race(
    val id: Int,
    val key: Key,
    val name: String
)

data class RealmX(
    val id: Int,
    val key: Key,
    val name: String,
    val slug: String
)

data class Reputations(
    val href: String
)

data class Specializations(
    val href: String
)

data class Statistics(
    val href: String
)

data class Titles(
    val href: String
)

data class Self(
    val href: String
)

data class Key(
    val href: String
)



data class ChosenCovenant(
    val id: Int,
    val key: Key,
    val name: String
)

data class Soulbinds(
    val href: String
)


data class FactionX(
    val name: String,
    val type: String
)


data class Realm(
    val id: Int,
    val key: Key,
    val name: String,
    val slug: String
)

