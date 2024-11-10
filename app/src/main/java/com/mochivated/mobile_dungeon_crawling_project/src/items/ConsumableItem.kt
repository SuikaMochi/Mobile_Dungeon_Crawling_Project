package com.mochivated.mobile_dungeon_crawling_project.src.items

import android.content.Context
import org.json.JSONObject

class ConsumableItem(c: Context, id: Int): Item(id) {
	private var cType: Int			= 0
	private var cEffectBase: Int	= 0
	private var cEffectModify: Int	= 0
	
	fun setCType(type: Int)				{ cType = type }
	fun setCEffectBase(eAmount: Int)	{ cEffectBase = eAmount }
	fun setCEffectModify(eModify: Int)	{ cEffectModify = eModify }
	
	fun getCType(): Int					{ return cType }
	fun getCEffectAmount(): Int			{ return cEffectBase }
	fun getCEffectModify(): Int			{ return cEffectModify }
	
	init {
		val jsonSave = JSONObject(c.openFileInput("com/mochivated/cungeon_drawling_standalone/src/items/consumable/$id.item").bufferedReader().readText())
		setCType(jsonSave.getInt("W_TYPE"))
		setCEffectBase(jsonSave.getInt("W_DAMAGE_TYPE"))
		setCEffectModify(jsonSave.getInt("W_DAMAGE_BASE"))
		setNAME(jsonSave.getString("NAME"))
		setDESC(jsonSave.getString("DESC"))
		setID(jsonSave.getInt("ID"))
		setRarity(jsonSave.getInt("RARITY"))
		setAmount(1)
	}
}