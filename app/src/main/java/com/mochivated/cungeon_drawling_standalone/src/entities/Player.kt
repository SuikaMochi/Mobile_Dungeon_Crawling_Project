package com.mochivated.cungeon_drawling_standalone.src.entities

import android.content.Context
import org.json.JSONObject

class Player() : EntityBase() {
	private var playerID: Int	= 0
	
	fun setPlayerID(id: Int)	{ playerID = id }
	fun getPlayerID(): Int		{ return playerID }
	
	fun loadPlayer(c: Context) {
		val jsonSave = JSONObject(c.openFileInput("$playerID.sav").bufferedReader().readText())
		setEName			(jsonSave.getString("NAME"))
		setEExperience		(jsonSave.getInt("EXPERIENCE"))
		setELevel			(jsonSave.getInt("LEVEL"))
		
		setEStrength		(jsonSave.getInt("STRENGTH"))
		setEEndurance		(jsonSave.getInt("ENDURANCE"))
		setEDexterity		(jsonSave.getInt("DEXTERITY"))
		
		setEAttunement		(jsonSave.getInt("ATTUNEMENT"))
		setEWisdom			(jsonSave.getInt("WISDOM"))
		setEFaith			(jsonSave.getInt("FAITH"))
		
		loadInventory		(c, jsonSave.getJSONObject("INVENTORY"))
	}
}