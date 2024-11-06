package com.mochivated.cungeon_drawling_standalone.src.items

open class Item(id: Int) {
	private var iId : Int		= id
	private var iRarity : Int	= 0
	private var iAmount : Int	= 0
	
	private var iName : String	= ""
	private var iDesc : String	= ""
	
	//Setters
	fun setID(id: Int)			{ iId = id }
	fun setRarity(rarity: Int)	{ iRarity = rarity }
	fun setAmount(amount: Int)	{ iAmount = amount }
	fun addAmount(amount: Int)	{ iAmount += amount }
	fun remAmount(amount: Int)	{ iAmount -= amount }
	
	fun setNAME(name: String)	{ iName = name }
	fun setDESC(desc: String)	{ iDesc = desc }
	
	//Getters
	fun getID(): Int			{return iId}
	fun getRarity(): Int		{return iRarity}
	fun getAmount(): Int		{return iAmount}
	
	fun getName(): String		{return iName}
	fun getDesc(): String		{return iDesc}
	
}
