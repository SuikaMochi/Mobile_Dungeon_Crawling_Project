package com.mochivated.cungeon_drawling_standalone.src.items.weapon

import android.content.Context
import com.mochivated.cungeon_drawling_standalone.src.items.Item
import org.json.JSONObject

class WeaponItem(c: Context, id: Int) : Item(id) {
	private var wType: Int			= 0
	private var wDamageType: Int	= 0
	private var wDamageBase: Int	= 0
	
	fun setWType(type: Int)			{ wType = type }
	fun setWDamageType(dType: Int)	{ wDamageType = dType }
	fun setWDamageBase(dBase: Int)	{ wDamageBase = dBase }
	
	fun getWType(): Int				{ return wType }
	fun getWDamageType(): Int		{ return wDamageType }
	fun getWDamageBase(): Int		{ return wDamageBase }
	
	init {
		val jsonSave = JSONObject(c.openFileInput("com/mochivated/cungeon_drawling_standalone/src/items/weapon/$id.item").bufferedReader().readText())
		setWType(jsonSave.getInt("W_TYPE"))
		setWDamageType(jsonSave.getInt("W_DAMAGE_TYPE"))
		setWDamageBase(jsonSave.getInt("W_DAMAGE_BASE"))
		setNAME(jsonSave.getString("NAME"))
		setDESC(jsonSave.getString("DESC"))
		setID(jsonSave.getInt("ID"))
		setRarity(jsonSave.getInt("RARITY"))
		setAmount(1)
	}
}