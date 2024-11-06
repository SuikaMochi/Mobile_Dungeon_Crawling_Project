package com.mochivated.cungeon_drawling_standalone.src.entities

import com.mochivated.cungeon_drawling_standalone.src.items.Inventory

open class EntityBase() : Inventory() {
	private var entityName: String		= "placeholder"
	
	private var entityStrength: Int			= 0
	private var entityEndurance: Int		= 0
	private var entityDexterity: Int		= 0
	
	private var entityIntelligence: Int		= 0
	private var entityWisdom: Int			= 0
	private var entityCharisma: Int			= 0
	
	private var entityExperience: Int		= 0
	private var entityLevel: Int			= 0
	
	fun setEName(name: String)				{ entityName = name }
	fun setEStrength(eStrength: Int)		{ entityStrength = eStrength }
	fun setEEndurance(eEndurance: Int)		{ entityEndurance = eEndurance }
	fun setEDexterity(eDexterity: Int)		{ entityDexterity = eDexterity }
	
	fun setEIntelligence(eIntelligence: Int){ entityIntelligence = eIntelligence }
	fun setEWisdom(eWisdom: Int)			{ entityWisdom = eWisdom }
	fun setECharisma(eCharisma: Int)		{ entityCharisma = eCharisma }
	
	fun setEExperience(eExperience: Int)	{ entityExperience = eExperience }
	fun setELevel(eLevel: Int)				{ entityLevel = eLevel }
	
	fun getEName(): String					{ return entityName }
	fun getEStrength(): Int					{ return entityStrength }
	fun getEEndurance(): Int				{ return entityEndurance }
	fun getEDexterity(): Int				{ return entityDexterity }
	
	fun getEIntelligence(): Int				{ return entityIntelligence }
	fun getEWisdom(): Int					{ return entityWisdom }
	fun getECharisma(): Int					{ return entityCharisma }
	
	fun getEExperience(): Int				{ return entityExperience }
	fun getELevel(): Int					{ return entityLevel }
}