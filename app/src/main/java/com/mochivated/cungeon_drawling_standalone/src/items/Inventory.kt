package com.mochivated.cungeon_drawling_standalone.src.items

import com.mochivated.cungeon_drawling_standalone.src.items.ammo.AmmoItem
import com.mochivated.cungeon_drawling_standalone.src.items.consumable.ConsumableItem
import com.mochivated.cungeon_drawling_standalone.src.items.flora.FloraItem
import com.mochivated.cungeon_drawling_standalone.src.items.gear.GearItem
import com.mochivated.cungeon_drawling_standalone.src.items.quest.QuestItem
import com.mochivated.cungeon_drawling_standalone.src.items.tool.ToolItem
import com.mochivated.cungeon_drawling_standalone.src.items.weapon.WeaponItem
import java.util.Vector

class Inventory {
	private var ammoInventory		= Vector<AmmoItem>()
	private var consumableInventory	= Vector<ConsumableItem>()
	private var floraInventory		= Vector<FloraItem>()
	private var gearInventory		= Vector<GearItem>()
	private var questInventory		= Vector<QuestItem>()
	private var toolInventory		= Vector<ToolItem>()
	private var weaponInventory		= Vector<WeaponItem>()
	private var lastItemAdd:String	= ""
	private var lastItemRem:String	= ""
	
	fun SetLastItemAdd(name: String) { lastItemAdd = name }
	fun SetLastItemRem(name: String) { lastItemRem = name }
}