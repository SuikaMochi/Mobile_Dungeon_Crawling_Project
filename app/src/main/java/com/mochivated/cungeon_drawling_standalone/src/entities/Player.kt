package com.mochivated.cungeon_drawling_standalone.src.entities

import android.content.Context
import org.json.JSONObject

class Player() : EntityBase() {
	private var playerID: Int		= 1000
	private var levelThreshold: Int	= 200
	
	private fun setPlayerID(id: Int)	{ playerID = id }
	private fun getPlayerID(): Int		{ return playerID }

	fun addExperience(exp: Int)			{
		setEExperience(getEExperience() + exp)
		if (getEExperience() >= levelThreshold)
		{
			setELevel(getELevel() + 1)
			val leftover = getEExperience() - levelThreshold
			setEExperience(leftover)
			levelThreshold *= getELevel()
		}
	}
	
	fun loadPlayer(c: Context) {
		val jsonSave = JSONObject(c.openFileInput("${getPlayerID()}.sav").bufferedReader().readText())
		setPlayerID			(jsonSave.getInt("ID"))
		
		setEName			(jsonSave.getString("NAME"))
		setEExperience		(jsonSave.getInt("EXPERIENCE"))
		setELevel			(jsonSave.getInt("LEVEL"))
		levelThreshold *= getELevel()
		
		setEStrength		(jsonSave.getInt("STRENGTH"))
		setEEndurance		(jsonSave.getInt("ENDURANCE"))
		setEDexterity		(jsonSave.getInt("DEXTERITY"))
		
		setEAttunement		(jsonSave.getInt("ATTUNEMENT"))
		setEWisdom			(jsonSave.getInt("WISDOM"))
		setEFaith			(jsonSave.getInt("FAITH"))
		
		loadInventory		(c, jsonSave.getJSONObject("INVENTORY"))
	}

	fun savePlayer(c: Context) {
		val saveJson = """
			{
				"NAME": "${getEName()}",
				"EXPERIENCE": ${getEExperience()},
				"LEVEL": ${getELevel()},
				"STRENGTH": ${getEStrength()},
				"DEXTERITY": ${getEDexterity()},
				"ENDURANCE": ${getEEndurance()},
				"ATTUNEMENT": ${getEAttunement()},
				"WISDOM": ${getEWisdom()},
				"FAITH": ${getEFaith()},
				"INVENTORY": ${saveInventory()}
			}
		""".trimIndent()

		c.openFileOutput("${getPlayerID()}.sav", Context.MODE_PRIVATE).use {
			it.write(saveJson.toByteArray())
		}
	}
}