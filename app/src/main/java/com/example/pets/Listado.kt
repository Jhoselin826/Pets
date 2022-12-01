package com.example.pets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_listado.*

class Listado : AppCompatActivity() {

    private val db2 = FirebaseFirestore.getInstance()
    private var listadoPerros: ListView? = null

    private val lista_Perros = arrayListOf(
        "Java",
        "Python",
        "wfffff",
        "ewfwwddw",
        "hhihiii",
        "hgkgk",
        "hhghgh",
        "fjvkjkhj"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)

        listadoPerros = findViewById(R.id.listaperros)


        //crear adaptador
        var adaptador: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista_Perros)
        listadoPerros?.adapter = adaptador



        btn_regresar.setOnClickListener {
            val saltar: Intent = Intent(this, MainActivity::class.java)
            startActivity(saltar)
        }

    }
}