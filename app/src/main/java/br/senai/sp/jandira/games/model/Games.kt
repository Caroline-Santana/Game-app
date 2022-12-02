package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "tbl_game")
class Games {

    @PrimaryKey(autoGenerate = true)
    var codigo = 0

    var nomeGame = ""
    var criador = ""
    var descricao = ""

    @ColumnInfo(name = "ano_lancamento")
    var anoLancamento = ""

    var statusGame:Boolean = false
    var imagem: Bitmap? = null

}