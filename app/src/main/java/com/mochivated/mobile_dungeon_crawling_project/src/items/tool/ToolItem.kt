package com.mochivated.mobile_dungeon_crawling_project.src.items.tool

import android.content.Context
import com.mochivated.mobile_dungeon_crawling_project.src.items.Item
import org.json.JSONObject

class ToolItem(c: Context, id: Int): Item(id) {
	
	init {
		val jsonSave = JSONObject(c.openFileInput("com/mochivated/cungeon_drawling_standalone/src/items/tool/$id.item").bufferedReader().readText())

		setNAME(jsonSave.getString("NAME"))
		setDESC(jsonSave.getString("DESC"))
		setID(jsonSave.getInt("ID"))
		setRarity(jsonSave.getInt("RARITY"))
		setAmount(1)
	}
}