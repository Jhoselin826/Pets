package com.example.pets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btn_registro.setOnClickListener(){
            var intentRegresar: Intent = Intent(this, LoginUser::class.java)
            startActivity(intentRegresar)
        }
        btn_listado.setOnClickListener(){
            var intentRegresar: Intent = Intent(this, Listado::class.java)
            startActivity(intentRegresar)
        }
    }
}