package com.mochivated.cungeon_drawling_standalone

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mochivated.cungeon_drawling_standalone.src.entities.Player
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
	private val player: Player = Player()
	private var openScreen: View? = null
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContentView(R.layout.activity_main)
		
		val loadingScreen: View = findViewById(R.id.loading_screen)
		val failScreen: View = findViewById(R.id.fail_screen)		//Used for debugging
		val successScreen: View = findViewById(R.id.success_screen)	//Used for debugging
		val characterCreatorScreen: View = findViewById(R.id.character_creator_screen)
		
		loadingScreen.run {
			loadingScreen.visibility = View.VISIBLE
			openScreen = loadingScreen
		}
		
		runBlocking {
			try {
				player.loadPlayer(baseContext)
				switchTo(successScreen)
			} catch (_: Exception) {
				switchTo(characterCreatorScreen)
			}
		}
		
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