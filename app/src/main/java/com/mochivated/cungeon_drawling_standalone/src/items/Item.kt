package com.mochivated.cungeon_drawling_standalone.src.items

open class Item(id: Int) {
	private var iId : Int		= id
	private var iRarity : Int	= 0
	private var iAmount : Int	= 0
	
	private var iName : String	= ""
	private var iDesc : String	= ""
	
	//Setters
	fun SetID(id: Int)			{ iId = id }
	fun SetRarity(rarity: Int)	{ iRarity = rarity }
	fun SetAmount(amount: Int)	{ iAmount = amount }
	fun AddAmount(amount: Int)	{ iAmount += amount }
	fun RemAmount(amount: Int)	{ iAmount -= amount }
	
	fun SetNAME(name: String)	{ iName = name }
	fun SetDESC(desc: String)	{ iDesc = desc }
	
	//Getters
	fun GetID(): Int			{return iId}
	fun GetRarity(): Int		{return iRarity}
	fun GetAmount(): Int		{return iAmount}
	
	fun GetName(): String		{return iName}
	fun GetDesc(): String		{return iDesc}
	
}
