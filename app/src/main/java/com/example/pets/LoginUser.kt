package com.example.pets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_login_user.*

enum class ProviderType{
    BASIC,
    GOOGLE,
    FACEBOOK
}

class LoginUser : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_user)

        val bundle:Bundle?=intent.extras
        val email:String? = bundle?.getString("email")
        val provider:String? = bundle?.getString("provider")


        setup(email?:"", provider?:"")
    }
    private fun setup(email:String, provider:String){
        title ="Inicio"
        tv_correo.text=email
        tv_provider.text=provider

        btn_salir.setOnClickListener(){
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
        btn_guardar.setOnClickListener(){
            db.collection("mascotas").document(email).set(
                hashMapOf("provider" to provider, "name" to et_nombre.text.toString(),
                    "edad" to et_edad.text.toString(), "raza" to et_raza.text.toString(),
                    "vicunas" to et_vacunas.text.toString(), "ultima" to et_ultima_vacuna.text.toString(),
                    "unfermented" to et_enfermedades.text.toString())
            )
        }
        btn_recuperar.setOnClickListener(){
            db.collection("mascotas").document(email).get().addOnSuccessListener {
                et_nombre.setText(it.get("address") as String?)
                et_edad.setText(it.get("phone") as String?)
                et_raza.setText(it.get("raza") as String?)
                et_vacunas.setText(it.get("vicunas") as String?)
                et_ultima_vacuna.setText(it.get("ultima") as String?)
                et_enfermedades.setText(it.get("unfermented") as String?)

            }
        }
        btn_borrar.setOnClickListener(){
            db.collection("users").document(email).delete()
        }
    }
}