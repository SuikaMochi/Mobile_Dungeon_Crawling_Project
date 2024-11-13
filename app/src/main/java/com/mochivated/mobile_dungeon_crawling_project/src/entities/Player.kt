package com.mochivated.mobile_dungeon_crawling_project.src.entities

import android.content.Context
import com.mochivated.mobile_dungeon_crawling_project.src.entities.settings.Settings
import org.json.JSONArray
import org.json.JSONObject
import java.io.File

class Player(private val c: Context) : EntityBase(c) {
	private val pSettings: Settings = Settings(c)

	private var playerID: Int			= 1000
	private var levelThreshold: Int		= 100
	private var playerFatigueMax: Int	= 1000
	private var playerFatigue: Int		= playerFatigueMax
	
	private fun setPlayerID(id: Int)	{ playerID = id }
	private fun getPlayerID(): Int		{ return playerID }

	fun setPlayerFatigueMax(fatigue: Int)	{ playerFatigueMax = fatigue }
	fun	getPlayerFatigueMax(): Int			{ return playerFatigueMax }

	fun setPlayerFatigue(fatigue: Int)	{ playerFatigue = fatigue }
	fun	getPlayerFatigue(): Int			{ return playerFatigue }

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

	//To be changed later to actually work as intended
	fun loseFatigue(loss: Int) { //Used for variable difficulty setting "Fatigue decrease speed"
		var amount: Int = 0
		amount = ((getEEndurance().toDouble() / getPlayerFatigueMax()) * pSettings.getFatigueLossSet()).toInt()
		setPlayerFatigue(getPlayerFatigue() - amount)
	}

	//To be changed later to actually work as intended
	fun loseExperience(loss: Int) { //Used for variable difficulty setting "Lose EXP progress on death"
		when (loss) {
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
		setEExperience		(setVariable(jsonSave, "EXPERIENCE"))
		setELevel			(setVariable(jsonSave,"LEVEL"))
		levelThreshold *= getELevel()

		setPlayerFatigueMax	(getEEndurance() * 100)
		setPlayerFatigue	(setVariable(jsonSave,"FATIGUE_CUR"))

		setEStrength		(setVariable(jsonSave,"STRENGTH"))
		setEDexterity		(setVariable(jsonSave,"DEXTERITY"))
		setEEndurance		(setVariable(jsonSave,"ENDURANCE"))
		
		setEAttunement		(setVariable(jsonSave,"ATTUNEMENT"))
		setEWisdom			(setVariable(jsonSave,"WISDOM"))
		setEFaith			(setVariable(jsonSave,"FAITH"))

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
			"FATIGUE_MAX": ${getPlayerFatigueMax()},
			"FATIGUE_CUR": ${getPlayerFatigue()},
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

	private fun setVariable(j: JSONObject, v: String): Int {
		return if (j.has(v)) {
			j.getInt(v)
		} else {
			0
		}
	}
}