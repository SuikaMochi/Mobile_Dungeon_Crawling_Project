# This is going to serve as an internal Wiki

## Item ID

Item ID's follow an 8 numbers long base, e.g.: 10000000
The first number of the ID indicates the type of item.
As following:
```
0...	->	Unused
1...	->	Consumables	->	Items that can be consumed, potions, etc.
2...	->	Weapons		->	Spears, swords, knives, crossbows, etc.
3...	->	Gear		->	Helmets, chest plates, shields, accessories, etc.
4...	->	Flora		->	Plants, mushrooms, etc. to be cooked or for alchemy
5...	->	Tools		->	Mining, cooking, lighting, etc.
6...	->	Ammunition	->	Throwing items or ammunition for bows, etc.		
7...	->	Unused		
8...	->	Unused		
9...	->	Quest		->	Quest and important story items
```

Item rarity modifier for shops and random overworld finds
### Item rarity
```
0		->	Common
1		->	Uncommon
2		->	Rare
3		->	Very rare
4		->	Legendary
5		->	"Unique"
```


# Consumables
Type of consumable
### C_TYPE
```
0		->	Restore		->	Restoring health or other drained stats
1		->	Buff		->	Buffing stats for a set time
2		->	Remedy		->	Removing debuffs such as poison, burn, etc.
3		->	Food		->	Cooked food
```

### C_EFFECT_BASE
```
Base amount for item effect
```

### C_EFFECT_MOD
```
Modifier for base item effect amount
```


# Weapons
Either close or long range attack
### W_TYPE
```
0		->	Close range
1		->	Long range
```

A weapon type carries a damage type
Some may carry multiple
### W_DAMAGE_TYPE
```
0		->	Slashing
1		->	Bludgeoning
2		->	Piercing
3		->	Burn
4		->	Freeze
5		->	Electric
```

### W_DAMAGE_BASE
```
Base amount of damage the weapon provides
```

# GEAR (Formerly Armour)
### G_TYPE
```
0		->	Helmet
1		->	Gauntlets
2		->	Greaves/Boots
3		->	Shield
4		->	Accessory
```

# Flora
### F_TYPE
```
```

# Tool
### T_TYPE
```
```


# Ammo
### AM_TYPE
```
```


# Quest
### Q_TYPE
```
```

