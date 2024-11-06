package com.mochivated.cungeon_drawling_standalone.src.items

import android.content.Context
import com.mochivated.cungeon_drawling_standalone.src.items.ammo.AmmoItem
import com.mochivated.cungeon_drawling_standalone.src.items.consumable.ConsumableItem
import com.mochivated.cungeon_drawling_standalone.src.items.flora.FloraItem
import com.mochivated.cungeon_drawling_standalone.src.items.gear.GearItem
import com.mochivated.cungeon_drawling_standalone.src.items.quest.QuestItem
import com.mochivated.cungeon_drawling_standalone.src.items.tool.ToolItem
import com.mochivated.cungeon_drawling_standalone.src.items.weapon.WeaponItem
import org.json.JSONObject
import org.json.JSONTokener
import java.util.Vector

open class Inventory {
	private var ammoInventory		= Vector<AmmoItem>()
	private var consumableInventory	= Vector<ConsumableItem>()
	private var floraInventory		= Vector<FloraItem>()
	private var gearInventory		= Vector<GearItem>()
	private var questInventory		= Vector<QuestItem>()
	private var toolInventory		= Vector<ToolItem>()
	private var weaponInventory		= Vector<WeaponItem>()
	private var lastItemAdd:String	= ""
	private var lastItemRem:String	= ""
	
	fun setLastItemAdd(name: String) { lastItemAdd = name }
	fun setLastItemRem(name: String) { lastItemRem = name }
	
	fun loadInventory(c: Context, jsonInventory: JSONObject) {
		for (item in jsonInventory.keys()) {
			val i: Int = item[0].code
			when (i) {
				1 -> ammoInventory.addElement(AmmoItem(c, item.toInt()))
				2 -> consumableInventory.addElement(ConsumableItem(c, item.toInt()))
				3 -> floraInventory.addElement(FloraItem(c, item.toInt()))
				4 -> gearInventory.addElement(GearItem(c, item.toInt()))
				5 -> questInventory.addElement(QuestItem(c, item.toInt()))
				6 -> toolInventory.addElement(ToolItem(c, item.toInt()))
				7 -> weaponInventory.addElement(WeaponItem(c, item.toInt()))
			}
		}
	}
}