package com.mochivated.mobile_dungeon_crawling_project.src.items

import android.content.Context
import org.json.JSONObject

class AmmoItem(c: Context, id: Int): Item(id) {
	
	init {
		val jsonSave = JSONObject(c.assets.open("items/ammo/${id}.item").bufferedReader().readText())

		setNAME(jsonSave.getString("NAME"))
		setDESC(jsonSave.getString("DESC"))
		setID(jsonSave.getInt("ID"))
		setRarity(jsonSave.getInt("RARITY"))
		setAmount(1)
	}
}