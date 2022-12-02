package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_console")
class Console {

    @PrimaryKey(autoGenerate = true)
    var codigo = 0

    var nome = ""
    var fabricante = ""
    var descricao = ""
    var foto: Bitmap?  = null

    @ColumnInfo(name = "ano_lancamento")
    var anoLancamento = 0

}