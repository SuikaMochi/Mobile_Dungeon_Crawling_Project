package com.mochivated.cungeon_drawling_standalone.src.items.gear

import android.content.Context
import com.mochivated.cungeon_drawling_standalone.src.items.Item
import org.json.JSONObject

class GearItem(c: Context, id: Int): Item(id) {
	
	init {
		val jsonSave = JSONObject(c.openFileInput("com/mochivated/cungeon_drawling_standalone/src/items/gear/$id.item").bufferedReader().readText())

		setNAME(jsonSave.getString("NAME"))
		setDESC(jsonSave.getString("DESC"))
		setID(jsonSave.getInt("ID"))
		setRarity(jsonSave.getInt("RARITY"))
		setAmount(1)
	}
}