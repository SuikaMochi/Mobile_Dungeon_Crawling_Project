package com.mochivated.cungeon_drawling_standalone.src.entities

import com.mochivated.cungeon_drawling_standalone.src.items.Inventory

open class EntityBase() : Inventory() {
	private var entityName: String		= "placeholder"
	
	private var entityStrength: Int			= 0
	private var entityEndurance: Int		= 0
	private var entityDexterity: Int		= 0
	
	private var entityAttunement: Int		= 0
	private var entityWisdom: Int			= 0
	private var entityFaith: Int			= 0
	
	private var entityExperience: Int		= 0
	private var entityLevel: Int			= 0
	
	fun setEName(name: String)				{ entityName = name }
	fun setEStrength(eStrength: Int)		{ entityStrength = eStrength }
	fun setEEndurance(eEndurance: Int)		{ entityEndurance = eEndurance }
	fun setEDexterity(eDexterity: Int)		{ entityDexterity = eDexterity }
	
	fun setEAttunement(eAttunement: Int)	{ entityAttunement = eAttunement }
	fun setEWisdom(eWisdom: Int)			{ entityWisdom = eWisdom }
	fun setEFaith(eFaith: Int)				{ entityFaith = eFaith }
	
	fun setEExperience(eExperience: Int)	{ entityExperience = eExperience }
	fun setELevel(eLevel: Int)				{ entityLevel = eLevel }
	
	fun getEName(): String					{ return entityName }
	fun getEStrength(): Int					{ return entityStrength }
	fun getEEndurance(): Int				{ return entityEndurance }
	fun getEDexterity(): Int				{ return entityDexterity }
	
	fun getEAttunement(): Int				{ return entityAttunement }
	fun getEWisdom(): Int					{ return entityWisdom }
	fun getEFaith(): Int					{ return entityFaith }
	
	fun getEExperience(): Int				{ return entityExperience }
	fun getELevel(): Int					{ return entityLevel }
}