package com.example.reviewapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.Date

class NomeActivity: AppCompatActivity() {
    lateinit var nome: EditText
    lateinit var email: EditText
    lateinit var data: CalendarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nome_activity)
        nome = findViewById(R.id.nome)
        email = findViewById(R.id.email)
        data = findViewById<CalendarView>(R.id.calendarView2)
        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            val nomeText = nome.text.toString()
            val emailText = email.text.toString()
            val dataText = Date(data.date).toString()
            val fragment = UsuarioFragment()
            val bundle = Bundle()
            bundle.putString ("nome", nomeText)
            bundle.putString("email", emailText)
            bundle.putString("data", dataText)

            fragment.arguments = bundle
            supportFragmentManager.beginTransaction().add(R.id.frameTop, fragment).commit()
            val intent = Intent(this@NomeActivity, AulasActivity::class.java)
            intent.putExtra("nome", nomeText)
            intent.putExtra("email", emailText)
            intent.putExtra("data", dataText)


            startActivity(intent)

        }
    }
}