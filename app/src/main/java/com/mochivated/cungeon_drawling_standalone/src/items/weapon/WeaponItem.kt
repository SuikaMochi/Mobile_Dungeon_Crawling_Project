package com.mochivated.cungeon_drawling_standalone.src.items.weapon

import com.mochivated.cungeon_drawling_standalone.src.items.Item

class WeaponItem(id: Int) : Item(id) {
	private var wType: Int			= 0
	private var wDamageType: Int	= 0
	private var wDamageBase: Int	= 0
	
	fun setWType(type: Int)			{ wType = type }
	fun setWDamageType(dType: Int)	{ wDamageType = dType }
	fun setWDamageBase(dBase: Int)	{ wDamageBase = dBase }
	
	fun getWType(): Int				{ return wType }
	fun getWDamageType(): Int		{ return wDamageType }
	fun getWDamageBase(): Int		{ return wDamageBase }
	
	
}