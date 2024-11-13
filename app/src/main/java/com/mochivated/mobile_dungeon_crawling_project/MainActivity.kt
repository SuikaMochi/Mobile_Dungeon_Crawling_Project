package com.mochivated.mobile_dungeon_crawling_project

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mochivated.mobile_dungeon_crawling_project.src.entities.Player

class MainActivity : AppCompatActivity() {
	private var player: Player? = null
	private var openScreen: View? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		player = Player(applicationContext)
		setContentView(R.layout.activity_main)
		
		val loadingScreen: View = findViewById(R.id.loading_screen)
		val failScreen: View = findViewById(R.id.fail_screen)		//Used for debugging
		val successScreen: View = findViewById(R.id.success_screen)	//Used for debugging
		val characterCreatorScreen: View = findViewById(R.id.character_creator_screen)
		val startScreen: View = findViewById(R.id.start_screen)

		val saveButton: Button = findViewById(R.id.saveButton)
		val startButton: Button = findViewById(R.id.startButton)

		saveButton.setOnClickListener {
			if (findViewById<EditText>(R.id.nameInput).text.isNotEmpty()) {
				try {
					player?.setEName(findViewById<EditText>(R.id.nameInput).text.toString())
					player?.setEStrength(findViewById<SeekBar>(R.id.strenthBar).progress)
					player?.setEDexterity(findViewById<SeekBar>(R.id.dexterityBar).progress)
					player?.setEEndurance(findViewById<SeekBar>(R.id.enduranceBar).progress)
					player?.setEAttunement(findViewById<SeekBar>(R.id.attunementBar).progress)
					player?.setEFaith(findViewById<SeekBar>(R.id.faithBar).progress)
					player?.setEWisdom(findViewById<SeekBar>(R.id.wisdomBar).progress)
					player?.setELevel(1)
					player?.savePlayer()
					switchTo(successScreen)
				} catch (e: Exception) {
					switchTo(failScreen)
					println(e.message)
				}
			}
		}

		startButton.setOnClickListener {
			try {
				player?.loadPlayer()
				switchTo(successScreen)
			} catch (e: Exception) {
				switchTo(characterCreatorScreen)
				println(e.message)
			}
		}

		loadingScreen.run {
			loadingScreen.visibility = View.VISIBLE
			openScreen = loadingScreen
		}

		switchTo(startScreen)

		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
			val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
			insets
		}
	}
	
	private fun switchTo(to: View)
	{
		openScreen?.run { openScreen?.visibility = View.GONE }
		to.run { to.visibility = View.VISIBLE }
		openScreen = to
	}
}