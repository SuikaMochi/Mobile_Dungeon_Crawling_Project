package com.mochivated.mobile_dungeon_crawling_project.src.items

import android.content.Context
import org.json.JSONObject
import java.util.Vector

open class Inventory(private val c: Context) {
	private var ammoInventory		= Vector<AmmoItem>()
	private var consumableInventory	= Vector<ConsumableItem>()
	private var floraInventory		= Vector<FloraItem>()
	private var gearInventory		= Vector<GearItem>()
	private var questInventory		= Vector<QuestItem>()
	private var toolInventory		= Vector<ToolItem>()
	private var weaponInventory		= Vector<WeaponItem>()

	private var headGearItem: GearItem = GearItem(c, 40000001)
	private var chestGearItem: GearItem = GearItem(c, 40000002)
	private var legGearItem: GearItem = GearItem(c, 40000003)
	private var leftHandWeaponItem: WeaponItem = WeaponItem(c, 70000002)
	private var rightHandWeaponItem: WeaponItem = WeaponItem(c, 70000002)

	private var lastItemAdd:String	= ""
	private var lastItemRem:String	= ""
	
	fun setLastItemAdd(name: String) { lastItemAdd = name }
	fun setLastItemRem(name: String) { lastItemRem = name }

	fun addItem(id: Int) {
		when (id.toString()[0].code) {
			1 -> if (getIndex(id) == -1) {
				ammoInventory.addElement(AmmoItem(c , id))
			} else {
				ammoInventory[getIndex(id)].addAmount(1)
			}
			2 -> if (getIndex(id) == -1) {
				consumableInventory.addElement(ConsumableItem(c, id))
			} else {
				consumableInventory[getIndex(id)].addAmount(1)
			}
			3 -> if (getIndex(id) == -1) {
				floraInventory.addElement(FloraItem(c, id))
			} else {
				floraInventory[getIndex(id)].addAmount(1)
			}
			4 -> if (getIndex(id) == -1) {
				gearInventory.addElement(GearItem(c, id))
			} else {
				gearInventory[getIndex(id)].addAmount(1)
			}
			5 -> if (getIndex(id) == -1) {
				questInventory.addElement(QuestItem(c, id))
			} else {
				questInventory[getIndex(id)].addAmount(1)
			}
			6 -> if (getIndex(id) == -1) {
				toolInventory.addElement(ToolItem(c, id))
			} else {
				toolInventory[getIndex(id)].addAmount(1)
			}
			7 -> if (getIndex(id) == -1) {
				weaponInventory.addElement(WeaponItem(c, id))
			} else {
				weaponInventory[getIndex(id)].addAmount(1)
			}
		}
	}

	fun loadInventory(jsonInventory: JSONObject) {
		for (item in jsonInventory.keys())
		{
			println(item)
		}
		println(jsonInventory)
	}

	fun saveInventory(): String {
		var inv = ""
		inv+= """"AMMO": {"""
		for (ammo in ammoInventory) {
			inv+=""""ID": ${ammo.getID()},"AMOUNT": ${ammo.getAmount()},""".trimIndent()
		}
		inv+= """},"""
		inv+= """"CONSUMABLE": {"""
		for (cons in consumableInventory) {
			inv+=""""ID": ${cons.getID()},"AMOUNT": ${cons.getAmount()},"""
		}
		inv.trimEnd(',')
		inv+= """},"""
		inv+= """"FLORA": {"""
		for (flor in floraInventory) {
			inv+=""""ID": ${flor.getID()},"AMOUNT": ${flor.getAmount()},"""
		}
		inv.trimEnd(',')
		inv+= """},"""
		inv+= """"GEAR": {"""
		for (gear in gearInventory) {
			inv+=""""ID": ${gear.getID()},"AMOUNT": ${gear.getAmount()},"""
		}
		inv.trimEnd(',')
		inv+= """},"""
		inv+= """"QUEST": {"""
		for (ques in questInventory) {
			inv+=""""ID": ${ques.getID()},"AMOUNT": ${ques.getAmount()},"""
		}
		inv.trimEnd(',')
		inv+= """},"""
		inv+= """"TOOL": {"""
		for (tool in toolInventory) {
			inv+=""""ID": ${tool.getID()},"AMOUNT": ${tool.getAmount()},"""
		}
		inv.trimEnd(',')
		inv+= """},"""
		inv+= """"WEAPON": {"""
		for (weap in weaponInventory) {
			inv+=""""ID": ${weap.getID()},"AMOUNT": ${weap.getAmount()},"""
		}
		inv.trimEnd(',')
		inv+= """}"""
		
		val saveJson = """
			{
				$inv
			}
		""".trimIndent()
		
		return saveJson
	}

	fun loadEquipped(jsonEquipped: JSONObject) {
	}

	fun saveEquipped(): String {
		var equipped = ""
		equipped+="""{
				"HEAD": {
					"ID": ${headGearItem.getID()}},
				"CHEST": {
					"ID": ${chestGearItem.getID()}},
				"LEGS": {
					"ID": ${legGearItem.getID()}},
				"L_WEAPON": {
					"ID": ${leftHandWeaponItem.getID()}},
				"R_WEAPON": {
					"ID": ${rightHandWeaponItem.getID()}}
			}""".trimIndent()
		return equipped
	}


	//Item carry capacity will hopefully limit the time this code will need
	private fun getIndex(id: Int): Int {
		when (id.toString()[0].code)
		{
			1 -> { for ((index, item) in ammoInventory.withIndex())
				{ if (item.getID() == id) { return index } } }
			2 -> { for ((index, item) in consumableInventory.withIndex())
				{ if (item.getID() == id) { return index } } }
			3 -> { for ((index, item) in floraInventory.withIndex())
				{ if (item.getID() == id) { return index } } }
			4 -> { for ((index, item) in gearInventory.withIndex())
				{ if (item.getID() == id) { return index } } }
			5 -> { for ((index, item) in questInventory.withIndex())
				{ if (item.getID() == id) { return index } } }
			6 -> { for ((index, item) in toolInventory.withIndex())
				{ if (item.getID() == id) { return index } } }
			7 -> { for ((index, item) in weaponInventory.withIndex())
				{ if (item.getID() == id) { return index } } }
		}
		return -1
	}
}