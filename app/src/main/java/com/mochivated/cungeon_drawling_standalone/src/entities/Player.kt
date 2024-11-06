package com.mochivated.cungeon_drawling_standalone.src.entities

class Player() : EntityBase() {
	private var playerID: Int	= 0
	
	fun setPlayerID(id: Int)	{ playerID = id }
	fun getPlayerID(): Int		{ return playerID }
}