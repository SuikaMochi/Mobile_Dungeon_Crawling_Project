package com.mochivated.mobile_dungeon_crawling_project.src.entities

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject
import java.io.File

class Player(private val c: Context) : EntityBase(c) {
	private var playerID: Int		= 1000
	private var levelThreshold: Int	= 100
	
	private fun setPlayerID(id: Int)	{ playerID = id }
	private fun getPlayerID(): Int		{ return playerID }

	fun addExperience(exp: Int) {
		setEExperience(getEExperience() + exp)
		if (getEExperience() >= levelThreshold)
		{
			setELevel(getELevel() + 1)
			val leftover = getEExperience() - levelThreshold
			setEExperience(leftover)
			levelThreshold = 100 * getELevel()
		}
	}

	fun loseExperience(loss: Int) { //Used for variable difficulty setting "Lose EXP progress on death"
		when (loss)
		{
			1 -> setEExperience(getEExperience())	//No loss
			2 -> setEExperience(getEExperience()/2)	//Lose half
			3 -> setEExperience(0)					//Lose all
		}
	}

	fun loadPlayer() {
		val v = c.packageManager.getPackageInfo(c.packageName, 0).versionName
		val file = File(c.filesDir, "${getPlayerID()}.sav")
		println("LOADING")
		println(file.path)

		val jsonSave = JSONArray(file.bufferedReader().readLines().toString()).getJSONObject(0)
		println(jsonSave)
		setPlayerID			(jsonSave.getInt("ID"))
		
		setEName			(jsonSave.getString("NAME"))
		setEExperience		(jsonSave.getInt("EXPERIENCE"))
		setELevel			(jsonSave.getInt("LEVEL"))
		levelThreshold *= getELevel()
		
		setEStrength		(jsonSave.getInt("STRENGTH"))
		setEDexterity		(jsonSave.getInt("DEXTERITY"))
		setEEndurance		(jsonSave.getInt("ENDURANCE"))
		
		setEAttunement		(jsonSave.getInt("ATTUNEMENT"))
		setEWisdom			(jsonSave.getInt("WISDOM"))
		setEFaith			(jsonSave.getInt("FAITH"))

		loadInventory		(jsonSave.getJSONObject("INVENTORY"))
		loadEquipped		(jsonSave.getJSONObject("EQUIPPED"))

		if (jsonSave.getString("VERSION") != v)
		{
			savePlayer()
		}
	}

	fun savePlayer() {
		val v = c.packageManager.getPackageInfo(c.packageName, 0).versionName
		val saveJson = """{
			"VERSION": "$v",
			"ID": ${getPlayerID()},
			"NAME": "${getEName()}",
			"EXPERIENCE": ${getEExperience()},
			"LEVEL": ${getELevel()},
			"STRENGTH": ${getEStrength()},
			"DEXTERITY": ${getEDexterity()},
			"ENDURANCE": ${getEEndurance()},
			"ATTUNEMENT": ${getEAttunement()},
			"WISDOM": ${getEWisdom()},
			"FAITH": ${getEFaith()},
			"INVENTORY": ${saveInventory()},
			"EQUIPPED": ${saveEquipped()}
		}""".trimIndent()

		val file = File(c.filesDir, "${getPlayerID()}.sav")
		file.createNewFile()
		file.writeText(JSONObject(saveJson).toString())
		println("SAVING")
		println(JSONObject(saveJson).toString())
		println(file.path)
	}
}