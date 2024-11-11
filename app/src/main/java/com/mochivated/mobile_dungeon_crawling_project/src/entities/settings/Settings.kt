package com.mochivated.mobile_dungeon_crawling_project.src.entities.settings

import android.content.Context

class Settings(val c: Context) { // Slider between 50 to 150, 50 = less, 100 = default, 150 = more
	private var experienceLoss: Int		= 100
	private var fatigueLoss: Int 		= 100
	private var moneyGain: Int 			= 100
	private var damageMultiply: Int		= 100

	fun setExperienceLossSet(set: Int)	{ experienceLoss = set }
	fun setFatigueLossSet(set: Int)		{ fatigueLoss = set }
	fun setMoneyGainSet(set: Int)		{ moneyGain = set }
	fun setDamageMultiplySet(set: Int)	{ damageMultiply = set }

	fun getExperienceLossSet(): Int		{ return experienceLoss }
	fun getFatigueLossSet(): Int		{ return fatigueLoss }
	fun getMoneyGainSet(): Int			{ return moneyGain }
	fun getDamageMultiplySet(): Int		{ return damageMultiply }

}