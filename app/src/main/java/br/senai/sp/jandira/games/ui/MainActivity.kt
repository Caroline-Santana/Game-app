package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.adapter.NewGameAdapter
import br.senai.sp.jandira.games.dao.GamesDao
import br.senai.sp.jandira.games.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var  rvJogos: RecyclerView
    lateinit var  adapterJogos: NewGameAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.textCreatUser.setOnClickListener {
            val abrirNewUserActivity = Intent(this, NewUserActivity::class.java)
            startActivity(abrirNewUserActivity)

        }
            binding.buttonLoginMain.setOnClickListener {
                login()
            }
        //Criar uma instância do RecyclerView
        rvJogos = findViewById(R.id.rv_games)

        //Determinar o layout do RecyclerView
        rvJogos.layoutManager=
            LinearLayoutManager (
                this,
                LinearLayoutManager.VERTICAL,
                false)

        //Criar uma instância do Adapter
        // lista de jogo
        adapterJogos = NewGameAdapter(this)

        val games = GamesDao.getGames(this)

        adapterJogos.updateGamesList(games)


        //Ligar o adapter á nossa RecyclerView
        rvJogos.adapter = adapterJogos

    }


    private fun login() {
        if (validar()){
            val email = binding.editTextEmailMain.text.toString()
            val pass = binding.editTextPasswordMain.text.toString()

            val dados = getSharedPreferences("dados", MODE_PRIVATE)

            val emailSp = dados.getString("email", "E-mail não encontrado")
            val passSp = dados.getString("password", "Senha incorreta")

            if(email == emailSp && pass ==passSp){
                val openShowGames = Intent(this, ShowGamesActivity::class.java)
                startActivity(openShowGames)

            }else{
                Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun validar(): Boolean {
        if( binding.editTextEmailMain.text.isEmpty()){
            binding.editTextEmailMain.error = "E-mail is required"
            return false
        }
        if(binding.editTextPasswordMain.text.isEmpty()){
            binding.editTextPasswordMain.error = "Password is required"
            return false
        }
        return true
    }


}
