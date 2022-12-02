package br.senai.sp.jandira.games.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.adapter.NewGameAdapter
import br.senai.sp.jandira.games.model.Games

class InsertGame : AppCompatActivity() {
    lateinit var rvNewGame: RecyclerView
    lateinit var adapterNewGame: NewGameAdapter
    lateinit var editNomeGame: EditText
    lateinit var editCriador: EditText
    lateinit var editDescricao: EditText
    lateinit var editYearGame: EditText
    lateinit var editStatusGame1: RadioButton
    lateinit var editStatusGame2: RadioButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_games)
        editNomeGame = findViewById(R.id.edit_text_game_name)
        editCriador = findViewById(R.id.edit_text_creator_game)
        editDescricao = findViewById(R.id.edit_text_description_game)
        editYearGame = findViewById(R.id.edit_text_year_game)
        editStatusGame1 = findViewById(R.id.radion_button_status_game1)
        editStatusGame2 = findViewById(R.id.radion_button_status_game2)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_new_user, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.menu_save -> {
                saveGame()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun saveGame() {

        val games = Games()
        games.codigo = 1
        games.nomeGame = editNomeGame.text.toString()
        games.criador = editCriador.text.toString()
        games.descricao = editDescricao.toString()
        games.anoLancamento = editYearGame.text.toString()

        if(editStatusGame1.isChecked) {
            games.statusGame = true
        }
        if (editStatusGame2.isChecked){
            games.statusGame = true
        }


        val dados = getSharedPreferences("dados", AppCompatActivity.MODE_PRIVATE)

        val editor = dados.edit()

        editor.putInt("id", games.codigo)
        editor.putString("name game", games.nomeGame)
        editor.putString("criador", games.criador)
        editor.putString("description", games.descricao)
        editor.putString("year game", games.anoLancamento)



        if (editor.commit()) {
            Toast.makeText(this, "Jogo gravado com sucesso", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "Ocorreu um erro na gravação", Toast.LENGTH_SHORT).show()
        }
    }
}