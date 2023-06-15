package com.example.reviewapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.reviewapp.databinding.ActivityEstruturaBinding

class EstruturaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estrutura)
        val nome = intent.getStringExtra("nome")
        val email = intent.getStringExtra("email")
        val data = intent.getStringExtra("data")
        var valorTot = intent.getDoubleExtra("rating", 0.0)

        val bundle = Bundle()
        bundle.putString("nome", nome)
        bundle.putString("email", email)
        bundle.putString("data", data)


        val fragment = UsuarioFragment()
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().add(R.id.frameTop, fragment).commit()

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar2)

        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener(){
            val valor = ratingBar.rating.toDouble()
            valorTot += valor
            val intent = Intent(this@EstruturaActivity, FinalActivity::class.java)
            intent.putExtra("nome", nome)
            intent.putExtra("email", email)
            intent.putExtra("rating", valorTot)
            intent.putExtra("data", data)


            startActivity(intent)
        }

    }
}