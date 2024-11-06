package com.mochivated.cungeon_drawling_standalone.src.items.consumable

import com.mochivated.cungeon_drawling_standalone.src.items.Item

class ConsumableItem(id: Int): Item(id) {
	private var cType: Int			= 0
	private var cEffectAmount: Int	= 0
	private var cEffectModify: Int	= 0
	
	fun setCType(type: Int)				{ cType = type }
	fun setCEffectAmount(eAmount: Int)	{ cEffectAmount = eAmount }
	fun setCEffectModify(eModify: Int)	{ cEffectModify = eModify }
	
	fun getCType(): Int					{ return cType }
	fun getCEffectAmount(): Int			{ return cEffectAmount }
	fun getCEffectModify(): Int			{ return cEffectModify }
}