package br.senai.sp.jandira.games.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivityGameBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ShowGamesActivity : AppCompatActivity() {

    lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadProfile()

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_game, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return  when (item.itemId) {
            R.id.menu_more -> {
                val abrirInsertGame = Intent(this, InsertGame::class.java)
                startActivity(abrirInsertGame)
                true
            }
            R.id.menu_exit -> {
                val abrirMainActivity = Intent(this, MainActivity::class.java)
                startActivity(abrirMainActivity)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



    private fun loadProfile() {
        //Abrir o arquivo SharedPreferences
        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        binding.textViewNameUser.text = dados.getString("name", "")
        binding.textViewEmailUser.text = dados.getString("email", "")
    }
}


