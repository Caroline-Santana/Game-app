package br.senai.sp.jandira.games.dao

import android.content.Context
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Games

class GamesDao {

    companion object {
        fun getGames(context: Context): List<Games> {

            val pt1 = Games()
            pt1.codigo = 1
            pt1.nomeGame = "Dead by daylight"
            pt1.criador = "Behaviour Interactive"
            pt1.descricao = "O jogo é jogado em um modo um contra quatro, onde um jogador assume o papel de um assassino, e os outros quatro jogam como sobreviventes, tendo que escapar do assassino e reparando cinco geradores para abrir os portões de saída e evitarem de serem capturados, enganchados e sacrificados."



            val Games = listOf(pt1)

            return Games
        }
    }


}