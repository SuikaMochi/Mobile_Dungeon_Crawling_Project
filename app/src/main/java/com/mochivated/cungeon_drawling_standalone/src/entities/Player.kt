package com.mochivated.cungeon_drawling_standalone.src.entities

import android.content.Context
import android.content.res.AssetManager
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Environment
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONString
import java.io.File

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
		
		loadInventory		(c, jsonSave.getJSONObject("INVENTORY"))

		if (jsonSave.getString("VERSION") != v || jsonSave.getString("VERSION").isNullOrEmpty())
		{
			savePlayer(c)
		}
	}

	fun savePlayer(c: Context) {
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
			"INVENTORY": ${saveInventory()}
		}""".trimIndent()

		val file = File(c.filesDir, "${getPlayerID()}.sav")
		file.createNewFile()
		file.writeText(JSONObject(saveJson).toString())
		println("SAVING")
		println(JSONObject(saveJson).toString())
		println(file.path)
	}
}