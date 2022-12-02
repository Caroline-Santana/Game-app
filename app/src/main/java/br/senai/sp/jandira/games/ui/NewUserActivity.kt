package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.adapter.NewUserAdapter
import br.senai.sp.jandira.games.model.User
import java.time.LocalDate

class NewUserActivity: AppCompatActivity() {
    lateinit var rvNewUser: RecyclerView
    lateinit var adapterNewUser: NewUserAdapter
    lateinit var  editNome: EditText
    lateinit var  editEmail: EditText
    lateinit var  editPassword: EditText
    lateinit var  editTown: EditText
    lateinit var  editBirth: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newuser)
        editNome = findViewById(R.id.edit_text_user_name)
        editEmail = findViewById(R.id.edit_text_email_user)
        editBirth = findViewById(R.id.text_view_user_birth)
        editPassword = findViewById(R.id.edit_text_password_user)
        editTown = findViewById(R.id.edit_text_town_user)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_new_user, menu)

        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.menu_save-> {
                saveUser()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun saveUser() {

        val user = User()
        user.codigo = 1
        user.nome = editNome.text.toString()
        user.email = editEmail.text.toString()
        user.dataNascimento = editBirth.toString()
        user.password = editPassword.text.toString()
        user.cidade = editTown.text.toString()


        val dados = getSharedPreferences("dados", AppCompatActivity.MODE_PRIVATE)

        val editor = dados.edit()

        editor.putInt("id", user.codigo)
        editor.putString("name", user.nome)
        editor.putString("email", user.email)
        editor.putString("password", user.password)
        editor.putString("birth", user.dataNascimento)
        editor.putString("town" , user.cidade)


        if (editor.commit()){
            Toast.makeText(this ,"Usuário gravado com sucesso", Toast.LENGTH_SHORT).show()
            finish()
        }else{
            Toast.makeText(this, "Ocorreu um erro na gravação", Toast.LENGTH_SHORT).show()
        }
    }
}