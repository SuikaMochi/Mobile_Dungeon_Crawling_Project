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
	private var shieldGearItem: GearItem = GearItem(c, 40000004)
	private var leftHandWeaponItem: WeaponItem = WeaponItem(c, 70000002)
	private var rightHandWeaponItem: WeaponItem = WeaponItem(c, 70000002)

	private var lastItemAdd:String	= ""
	private var lastItemRem:String	= ""
	
	fun setLastItemAdd(name: String) { lastItemAdd = name }
	fun setLastItemRem(name: String) { lastItemRem = name }

	fun getHeadGear(): GearItem {
		return headGearItem
	}

	fun getChestGear(): GearItem {
		return headGearItem
	}

	fun getLegGear(): GearItem {
		return headGearItem
	}

	fun getShieldGear(): GearItem {
		return headGearItem
	}

	fun getRHandWeapon(): WeaponItem {
		return rightHandWeaponItem
	}

	fun getLHandWeapon(): WeaponItem {
		return leftHandWeaponItem
	}

	fun addItem(id: Int, amount: Int) {
		when (id.toString()[0].code) {
			1 -> if (getIndex(id) == -1) {
				ammoInventory.addElement(AmmoItem(c , id))
			} else {
				ammoInventory[getIndex(id)].addAmount(amount - 1)
			}
			2 -> if (getIndex(id) == -1) {
				consumableInventory.addElement(ConsumableItem(c, id))
			} else {
				consumableInventory[getIndex(id)].addAmount(amount - 1)
			}
			3 -> if (getIndex(id) == -1) {
				floraInventory.addElement(FloraItem(c, id))
			} else {
				floraInventory[getIndex(id)].addAmount(amount - 1)
			}
			4 -> if (getIndex(id) == -1) {
				gearInventory.addElement(GearItem(c, id))
			} else {
				gearInventory[getIndex(id)].addAmount(amount - 1)
			}
			5 -> if (getIndex(id) == -1) {
				questInventory.addElement(QuestItem(c, id))
			} else {
				questInventory[getIndex(id)].addAmount(amount - 1)
			}
			6 -> if (getIndex(id) == -1) {
				toolInventory.addElement(ToolItem(c, id))
			} else {
				toolInventory[getIndex(id)].addAmount(amount - 1)
			}
			7 -> if (getIndex(id) == -1) {
				weaponInventory.addElement(WeaponItem(c, id))
			} else {
				weaponInventory[getIndex(id)].addAmount(amount - 1)
			}
		}
	}

	fun remItem(id: Int, amount: Int) {
		when (id.toString()[0].code) {
			1 -> if (getIndex(id) == -1) {
				ammoInventory[getIndex(id)].remAmount(amount - 1)
				if (ammoInventory[getIndex(id)].getAmount() <= 0) {
					ammoInventory.removeElementAt(getIndex(id))
				}
			}
			2 -> if (getIndex(id) == -1) {
				consumableInventory[getIndex(id)].remAmount(amount - 1)
				if (consumableInventory[getIndex(id)].getAmount() <= 0) {
					consumableInventory.removeElementAt(getIndex(id))
				}
			}
			3 -> if (getIndex(id) == -1) {
				floraInventory[getIndex(id)].addAmount(amount - 1)
				if (floraInventory[getIndex(id)].getAmount() <= 0) {
					floraInventory.removeElementAt(getIndex(id))
				}
			}
			4 -> if (getIndex(id) == -1) {
				gearInventory[getIndex(id)].addAmount(amount - 1)
				if (gearInventory[getIndex(id)].getAmount() <= 0) {
					gearInventory.removeElementAt(getIndex(id))
				}
			}
			5 -> if (getIndex(id) == -1) {
				questInventory[getIndex(id)].addAmount(amount - 1)
				if (questInventory[getIndex(id)].getAmount() <= 0) {
					questInventory.removeElementAt(getIndex(id))
				}
			}
			6 -> if (getIndex(id) == -1) {
				toolInventory[getIndex(id)].addAmount(amount - 1)
				if (toolInventory[getIndex(id)].getAmount() <= 0) {
					toolInventory.removeElementAt(getIndex(id))
				}
			}
			7 -> if (getIndex(id) == -1) {
				weaponInventory[getIndex(id)].addAmount(amount - 1)
				if (weaponInventory[getIndex(id)].getAmount() <= 0) {
					weaponInventory.removeElementAt(getIndex(id))
				}
			}
		}
	}

	fun loadInventory(jsonInventory: JSONObject) {
		println("jsonInventory")
		println(jsonInventory)
		for (item in jsonInventory.keys()) {
			val it = jsonInventory.getJSONObject(item)
			if (it.has("ID"))
			{ addItem(it.getInt("ID"), it.getInt("AMOUNT")) }
		}
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

	fun unEquipGearItem(slot: Int) {
		when (slot) {
			0 -> if (headGearItem.getName() != "Empty") {
				addItem(headGearItem.getID(), 1)
				headGearItem = GearItem(c, 40000001)
			}
			1 -> if (chestGearItem.getName() != "Empty") {
				addItem(chestGearItem.getID(), 1)
				chestGearItem = GearItem(c, 40000002)
			}
			2 -> if (legGearItem.getName() != "Empty") {
				addItem(legGearItem.getID(), 1)
				legGearItem = GearItem(c, 40000003)
			}
			3 -> if (shieldGearItem.getName() != "Empty") {
				addItem(shieldGearItem.getID(), 1)
				shieldGearItem = GearItem(c, 40000004)
			}
		}
	}

	fun equipGearItem(id: Int) {
		val itemToEquip: GearItem? = gearInventory[getIndex(id)]
		if (itemToEquip != null) {
			when (itemToEquip.getGSlot()) {
				0 -> {
					unEquipGearItem(0)
					headGearItem = itemToEquip
				}
				1 -> {
					unEquipGearItem(1)
					chestGearItem = itemToEquip
				}
				2 -> {
					unEquipGearItem(2)
					legGearItem = itemToEquip
				}
				3 -> {
					unEquipGearItem(3)
					shieldGearItem = itemToEquip
				}
			}
		}
	}

	fun equipWeaponItem(id: Int) {
		val itemToEquip: WeaponItem? = weaponInventory[getIndex(id)]
		if (itemToEquip != null) {
			if (itemToEquip.getWSize() == 0) {
				if (leftHandWeaponItem.getName() != "Empty") {
					addItem(leftHandWeaponItem.getID(), 1)
				}
				rightHandWeaponItem = itemToEquip
				remItem(id, 1)
			}
			else {
				if (leftHandWeaponItem.getName() != "Empty") {
					addItem(leftHandWeaponItem.getID(), 1)
					addItem(rightHandWeaponItem.getID(), 1)
				}
				leftHandWeaponItem = itemToEquip
				rightHandWeaponItem = itemToEquip
				remItem(id, 1)
			}
		}
	}

	fun loadEquipped(jsonEquipped: JSONObject) {
		println("jsonEquipped")
		println(jsonEquipped)
		for (item in jsonEquipped.keys()) {
			val it = jsonEquipped.getJSONObject(item)
			if (it.has("ID"))
			{
				when (it.getInt("ID").toString()[0].code) {
					4 -> {
						val gear = GearItem(c, it.getInt("ID"))
						when (gear.getGSlot()) {
							0 -> {
								headGearItem = gear
							}

							1 -> {
								chestGearItem = gear
							}

							2 -> {
								legGearItem = gear
							}

							3 -> {
								shieldGearItem = gear
							}
						}
					}
					7 -> {
						val weap = WeaponItem(c, it.getInt("ID"))
						when (it.getInt("SLOT")) {
							0 -> leftHandWeaponItem = weap
							1 -> rightHandWeaponItem = weap
						}
					}
				}
			}
		}
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
					"SLOT": 0,
					"ID": ${leftHandWeaponItem.getID()}},
				"R_WEAPON": {
					"SLOT": 1,
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