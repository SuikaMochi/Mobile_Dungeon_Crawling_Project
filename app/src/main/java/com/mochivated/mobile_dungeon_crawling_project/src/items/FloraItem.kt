package com.mochivated.mobile_dungeon_crawling_project.src.items

import android.content.Context
import org.json.JSONObject

class FloraItem(c: Context, id: Int): Item(id) {
	
	init {
		val jsonSave = JSONObject(c.openFileInput("com/mochivated/cungeon_drawling_standalone/src/items/flora/$id.item").bufferedReader().readText())

		setNAME(jsonSave.getString("NAME"))
		setDESC(jsonSave.getString("DESC"))
		setID(jsonSave.getInt("ID"))
		setRarity(jsonSave.getInt("RARITY"))
		setAmount(1)
	}
}