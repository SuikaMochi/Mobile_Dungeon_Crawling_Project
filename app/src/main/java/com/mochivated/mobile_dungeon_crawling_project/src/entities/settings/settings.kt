package com.mochivated.mobile_dungeon_crawling_project.src.entities.settings

import android.content.Context

class settings(val c: Context) { // Slider between 50 to 150, 50 = less, 100 = default, 150 = more
    var experienceLoss: Int = 100
    var fatigueLoss: Int = 100
    var moneyGain: Int = 100
    var damageTake: Int = 100
}