package com.mochivated.cungeon_drawling_standalone.src.items.weapon

import com.mochivated.cungeon_drawling_standalone.src.items.Item

class WeaponItem(id: Int) : Item(id) {
	private var wType: Int			= 0
	private var wDamageType: Int	= 0
	private var wDamageBase: Int	= 0
	
	fun SetWType(type: Int)			{ wType = type }
	fun SetWDamgeType(dType: Int)	{ wDamageType = dType }
	fun SetWDamgeBase(dBase: Int)	{ wDamageBase = dBase }
	
	fun GetWType(): Int				{ return wType }
	fun GetWDamgeType(): Int		{ return wDamageType }
	fun GetWDamgeBase(): Int		{ return wDamageBase }
	
	
}