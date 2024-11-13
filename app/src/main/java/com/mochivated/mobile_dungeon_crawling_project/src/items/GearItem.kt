package com.mochivated.mobile_dungeon_crawling_project.src.items

import android.content.Context
import android.content.res.AssetManager
import org.json.JSONObject

class GearItem(c: Context, id: Int): Item(id) {
	private var gSlot = 0
	private var gSlashResistance = 0
	private var gPierceResistance = 0
	private var gBashResistance = 0
	private var gFireResistance = 0
	private var gIceResistance = 0
	private var gShockResistance = 0

	private fun setGSlot(slot: Int)				{ gSlot = slot }
	private fun setGSlashResistance(res: Int)	{ gSlashResistance = res }
	private fun setGPierceResistance(res: Int)	{ gPierceResistance = res }
	private fun setGBashResistance(res: Int)	{ gBashResistance = res }
	private fun setGFireResistance(res: Int)	{ gFireResistance = res }
	private fun setGIceResistance(res: Int)		{ gIceResistance = res }
	private fun setGShockResistance(res: Int)	{ gShockResistance = res }

	fun getGSlot(): Int					{ return gSlot }
	fun getGSlashResistance(): Int		{ return gSlashResistance }
	fun getGPierceResistance(): Int		{ return gPierceResistance }
	fun getGBashResistance(): Int		{ return gBashResistance }
	fun getGFireResistance(): Int		{ return gFireResistance }
	fun getGIceResistance(): Int		{ return gIceResistance }
	fun getGShockResistance(): Int		{ return gShockResistance }

	init {
		val jsonSave = JSONObject(c.assets.open("items/gear/${id}.item").bufferedReader().readText())

		setNAME(jsonSave.getString("NAME"))
		setDESC(jsonSave.getString("DESC"))
		setID(jsonSave.getInt("ID"))
		setRarity(jsonSave.getInt("RARITY"))
		setAmount(1)
		setGSlot(jsonSave.getInt("G_SLOT"))
		setGSlashResistance(jsonSave.getInt("G_SLASH_RES"))
		setGPierceResistance(jsonSave.getInt("G_PIERCE_RES"))
		setGBashResistance(jsonSave.getInt("G_BASH_RES"))
		setGFireResistance(jsonSave.getInt("G_FIRE_RES"))
		setGIceResistance(jsonSave.getInt("G_ICE_RES"))
		setGShockResistance(jsonSave.getInt("G_SHOCK_RES"))
	}
}