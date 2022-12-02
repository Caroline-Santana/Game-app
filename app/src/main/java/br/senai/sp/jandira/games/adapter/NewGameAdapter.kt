package br.senai.sp.jandira.games.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Games

class NewGameAdapter (var context: Context): RecyclerView.Adapter<NewGameAdapter.HolderGamePt>() {
    private var gameList = listOf<Games>()

    fun updateGamesList(game: List<Games>){
        this.gameList = game
        notifyDataSetChanged()
    }

    // Criar uma inner class
    class HolderGamePt(view: View): RecyclerView.ViewHolder(view) {

        val textTituloPt = view.findViewById<TextView>(R.id.text_view_title_game)
        val textDescricao = view.findViewById<TextView>(R.id.text_view_descricao)
//        val imageHolder = view.findViewById<ImageView>(R.id.image_holder)
        val textCreator = view.findViewById<Button>(R.id.text_view_criador_game)

        fun bind(games: Games) {
            textTituloPt.text = games.nomeGame
            textDescricao.text = games.descricao
            textCreator.text = games.criador

        }
    }

    override fun onBindViewHolder(holder: HolderGamePt, position: Int) {
        val game = gameList[position]
        holder.bind(game)
    }

    override fun getItemCount(): Int {
        return gameList.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderGamePt {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_layout, parent, false)
        return HolderGamePt(view)
    }
}