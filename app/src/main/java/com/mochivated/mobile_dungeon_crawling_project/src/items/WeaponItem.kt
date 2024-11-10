package com.mochivated.mobile_dungeon_crawling_project.src.items

import android.content.Context
import org.json.JSONObject

class WeaponItem(c: Context, id: Int) : Item(id) {
	private var wType: Int			= 0
	private var wDamageType: Int	= 0
	private var wDamageBase: Int	= 0

	private fun setWType(type: Int)			{ wType = type }
	private fun setWDamageType(dType: Int)	{ wDamageType = dType }
	private fun setWDamageBase(dBase: Int)	{ wDamageBase = dBase }
	
	fun getWType(): Int				{ return wType }
	fun getWDamageType(): Int		{ return wDamageType }
	fun getWDamageBase(): Int		{ return wDamageBase }
	
	init {
		val jsonSave = JSONObject(c.assets.open("${id}.item").bufferedReader().readText())
		setNAME(jsonSave.getString("NAME"))
		setDESC(jsonSave.getString("DESC"))
		setID(jsonSave.getInt("ID"))
		setRarity(jsonSave.getInt("RARITY"))
		setAmount(1)
		setWType(jsonSave.getInt("W_TYPE"))
		setWDamageType(jsonSave.getInt("W_DAMAGE_TYPE"))
		setWDamageBase(jsonSave.getInt("W_DAMAGE_BASE"))
	}
}