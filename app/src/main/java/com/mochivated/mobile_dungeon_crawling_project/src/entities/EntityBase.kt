package com.mochivated.mobile_dungeon_crawling_project.src.entities

import android.content.Context
import com.mochivated.mobile_dungeon_crawling_project.src.items.Inventory

open class EntityBase(private val c: Context) : Inventory(c) {
	private var entityName: String			= "placeholder"

	private var entityHealth: Int			= 0
	private var entityMana: Int				= 0

	private var entityStrength: Int			= 0
	private var entityEndurance: Int		= 0
	private var entityDexterity: Int		= 0
	
	private var entityAttunement: Int		= 0
	private var entityWisdom: Int			= 0
	private var entityFaith: Int			= 0
	
	private var entityExperience: Int		= 0
	private var entityLevel: Int			= 0

	//Setter
	fun setEName(name: String)				{ entityName = name }

	fun setEHealth(health: Int)				{ entityHealth = health }
	fun setEMana(mana: Int)					{ entityMana = mana }

	fun setEStrength(eStrength: Int)		{ entityStrength = eStrength }
	fun setEEndurance(eEndurance: Int)		{ entityEndurance = eEndurance }
	fun setEDexterity(eDexterity: Int)		{ entityDexterity = eDexterity }
	
	fun setEAttunement(eAttunement: Int)	{ entityAttunement = eAttunement }
	fun setEWisdom(eWisdom: Int)			{ entityWisdom = eWisdom }
	fun setEFaith(eFaith: Int)				{ entityFaith = eFaith }
	
	fun setEExperience(eExperience: Int)	{ entityExperience = eExperience }
	fun setELevel(eLevel: Int)				{ entityLevel = eLevel }

	//Getter
	fun getEName(): String					{ return entityName }

	fun getEHealth(): Int					{ return entityHealth }
	fun getEMana(): Int						{ return entityMana }

	fun getEStrength(): Int					{ return entityStrength }
	fun getEEndurance(): Int				{ return entityEndurance }
	fun getEDexterity(): Int				{ return entityDexterity }
	
	fun getEAttunement(): Int				{ return entityAttunement }
	fun getEWisdom(): Int					{ return entityWisdom }
	fun getEFaith(): Int					{ return entityFaith }
	
	fun getEExperience(): Int				{ return entityExperience }
	fun getELevel(): Int					{ return entityLevel }

	//Resistances and other combat related Gets
	fun getESpeed(): Int					{ return (entityEndurance + entityDexterity) / 2 }

	fun getESlashResistance(): Int			{
		return getHeadGear().getGSlashResistance() + getChestGear().getGSlashResistance() +
				getLegGear().getGSlashResistance() + getShieldGear().getGSlashResistance()}
	fun getEPierceResistance(): Int			{
		return getHeadGear().getGPierceResistance() + getChestGear().getGPierceResistance() +
				getLegGear().getGPierceResistance() + getShieldGear().getGPierceResistance()}
	fun getEBashResistance(): Int			{
		return getHeadGear().getGBashResistance() + getChestGear().getGBashResistance() +
				getLegGear().getGBashResistance() + getShieldGear().getGBashResistance()}

	fun getEFireResistance(): Int			{
		return getHeadGear().getGFireResistance() + getChestGear().getGFireResistance() +
				getLegGear().getGFireResistance() + getShieldGear().getGFireResistance()}
	fun getEIceResistance(): Int			{
		return getHeadGear().getGIceResistance() + getChestGear().getGIceResistance() +
				getLegGear().getGIceResistance() + getShieldGear().getGIceResistance()}
	fun getEShockResistance(): Int			{
		return getHeadGear().getGShockResistance() + getChestGear().getGShockResistance() +
				getLegGear().getGShockResistance() + getShieldGear().getGShockResistance()}
}