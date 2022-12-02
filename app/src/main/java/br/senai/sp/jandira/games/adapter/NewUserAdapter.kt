package br.senai.sp.jandira.games.adapter

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.User


class NewUserAdapter(var userList: List<User>, var context: Context): RecyclerView.Adapter<NewUserAdapter.UserHolder>() {

    fun updateUserList(newUserList: List<User>){
        this.userList = newUserList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_game,parent,false)
        return UserHolder(view)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val user = userList[position]

        holder.textViewNome.text = user.nome
        holder.textViewEmail.text = user.email
//        holder.textViewImage. = user.foto
//        holder.textViewAge.text = user.dataNascimento
        holder.textViewLevel.text = user.nivel.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }
    class UserHolder(view: View): RecyclerView.ViewHolder(view){
        val textViewNome: TextView = view.findViewById(R.id.text_view_name_user)
        val textViewEmail: TextView = view.findViewById(R.id.text_view_email_user)
//        val textViewImage: Bitmap = view.findViewById(R.id.image_view_profile_user)
//        val textViewAge: TextView = view.findViewById(R.id.text_view_user_birth)
        val textViewLevel: TextView = view.findViewById(R.id.text_view_level_user)
    }
}