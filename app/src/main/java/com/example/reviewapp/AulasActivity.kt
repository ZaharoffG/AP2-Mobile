package com.example.reviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar

class AulasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aulas)
        val nome = intent.getStringExtra("nome")
        val email = intent.getStringExtra("email")
        val data = intent.getStringExtra("data")


        val bundle = Bundle()
        bundle.putString("nome", nome)
        bundle.putString("email", email)
        bundle.putString("data", data)


        val fragment = UsuarioFragment()
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().add(R.id.frameTop, fragment).commit()

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)

        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener(){
            val valor = ratingBar.rating.toDouble()
            val intent = Intent(this@AulasActivity, EstruturaActivity::class.java)
            intent.putExtra("nome", nome)
            intent.putExtra("email", email)
            intent.putExtra("rating", valor)
            intent.putExtra("data", data)


            startActivity(intent)
        }

    }
}