data class WowEquipmentResponse(
        val _links: Links,
        val character: Character,
        val equipped_item_sets: List<EquippedItemSet>,
        val equipped_items: List<EquippedItem>
)

data class Character(
        val id: Int,
        val key: Key,
        val name: String,
        val realm: Realm
)

data class EquippedItemSet(
        val display_string: String,
        val effects: List<Effect>,
        val item_set: ItemSet,
        val items: List<Item>
)

data class EquippedItem(
        val armor: Armor,
        val binding: Binding,
        val bonus_list: List<Int>,
        val context: Int,
        val description: String,
        val durability: Durability,
        val enchantments: List<Enchantment>,
        val inventory_type: InventoryType,
        val is_subclass_hidden: Boolean,
        val item: Item,
        val item_class: ItemClass,
        val item_subclass: ItemSubclass,
        val level: Level,
        val limit_category: String,
        val media: Media,
        val modified_appearance_id: Int,
        val name: String,
        val name_description: NameDescription,
        val quality: Quality,
        val quantity: Int,
        val requirements: Requirements,
        val sell_price: SellPrice,
        val `set`: Set,
        val slot: Slot,
        val spells: List<Spell>,
        val stats: List<Stat>,
        val transmog: Transmog,
        val unique_equipped: String,
        val weapon: Weapon
)


data class Effect(
        val display_string: String,
        val is_active: Boolean,
        val required_count: Int
)

data class ItemSet(
        val id: Int,
        val key: Key,
        val name: String
)

data class Item(
        val is_equipped: Boolean,
        val item: ItemRespresentation
)

data class ItemRespresentation(
        val id: Int,
        val key: Key,
        val name: String
)


data class Armor(
        val display: Display,
        val value: Int
)

data class Binding(
        val name: String,
        val type: String
)

data class Durability(
        val display_string: String,
        val value: Int
)

data class Enchantment(
        val display_string: String,
        val enchantment_id: Int,
        val enchantment_slot: EnchantmentSlot,
        val source_item: SourceItem
)

data class InventoryType(
        val name: String,
        val type: String
)


data class ItemClass(
        val id: Int,
        val key: Key,
        val name: String
)

data class ItemSubclass(
        val id: Int,
        val key: Key,
        val name: String
)

data class Level(
        val display_string: String,
        val value: Int
)


data class NameDescription(
        val color: Color,
        val display_string: String
)

data class Quality(
        val name: String,
        val type: String
)

data class Requirements(
        val level: Level,
        val playable_races: PlayableRaces
)

data class SellPrice(
        val display_strings: DisplayStrings,
        val value: Int
)

data class Set(
        val display_string: String,
        val effects: List<Effect>,
        val item_set: ItemSet,
        val items: List<Item>
)

data class Slot(
        val name: String,
        val type: String
)

data class Spell(
        val description: String,
        val spell: Spell
)

data class Stat(
        val display: Display,
        val is_equip_bonus: Boolean,
        val is_negated: Boolean,
        val type: Type,
        val value: Int
)

data class Transmog(
        val display_string: String,
        val item: Item,
        val item_modified_appearance_id: Int
)

data class Weapon(
        val attack_speed: AttackSpeed,
        val damage: Damage,
        val dps: Dps
)

data class Display(
        val color: Color,
        val display_string: String
)

data class Color(
        val a: Double,
        val b: Int,
        val g: Int,
        val r: Int
)

data class EnchantmentSlot(
        val id: Int,
        val type: String
)

data class SourceItem(
        val id: Int,
        val key: Key,
        val name: String
)

data class PlayableRaces(
        val display_string: String,
        val links: List<Link>
)

data class Link(
        val id: Int,
        val key: Key,
        val name: String
)


data class DisplayStrings(
        val copper: String,
        val gold: String,
        val header: String,
        val silver: String
)


data class Type(
        val name: String,
        val type: String
)

data class AttackSpeed(
        val display_string: String,
        val value: Int
)

data class Damage(
        val damage_class: DamageClass,
        val display_string: String,
        val max_value: Int,
        val min_value: Int
)

data class Dps(
        val display_string: String,
        val value: Double
)

data class DamageClass(
        val name: String,
        val type: String
)