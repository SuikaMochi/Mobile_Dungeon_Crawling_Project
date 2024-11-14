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
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
	private var player: Player? = null
	private var openScreen: View? = null
	private var loadingScreen: View? = null
	private var failScreen: View? = null		//Used for debugging
	private var successScreen: View? = null	//Used for debugging
	private var characterCreatorScreen: View? = null
	private var startScreen: View? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		player = Player(applicationContext)
		setContentView(R.layout.activity_main)
		
		loadingScreen = findViewById(R.id.loading_screen)
		failScreen = findViewById(R.id.fail_screen)		//Used for debugging
		successScreen = findViewById(R.id.success_screen)	//Used for debugging
		characterCreatorScreen = findViewById(R.id.character_creator_screen)
		startScreen = findViewById(R.id.start_screen)
		
		setupStartScreen()
		setupCharacterCreatorScreen()
		
		loadingScreen.run {
			loadingScreen?.visibility = View.VISIBLE
			openScreen = loadingScreen
		}

		switchTo(startScreen)

		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
			val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
			insets
		}
	}
	
	private fun switchTo(to: View?)
	{
		openScreen?.run { openScreen?.visibility = View.GONE }
		to.run { to?.visibility = View.VISIBLE }
		openScreen = to
	}
	
	private fun setupStartScreen() {
		findViewById<Button>(R.id.startButton)
			.setOnClickListener {
			switchTo(loadingScreen)
			runBlocking {
				try {
					player?.loadPlayer()
					switchTo(successScreen)
				} catch (e: Exception) {
					switchTo(characterCreatorScreen)
					println(e.message)
				}
			}
		}
	}
	
	private fun setupCharacterCreatorScreen() {
		findViewById<Button>(R.id.saveButton).setOnClickListener {
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
	}
}