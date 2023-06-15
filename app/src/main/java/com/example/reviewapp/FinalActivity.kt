package com.example.reviewapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import org.w3c.dom.Text

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

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

        val nota: TextView = findViewById(R.id.nota)
        nota.setText(valorTot.toString())

        val resultado: TextView = findViewById(R.id.resultado)
        if (valorTot <= 5) {
            resultado.setText("Resultado: MUITO RUIM")
        } else if (valorTot > 5 && valorTot < 6) {
            resultado.setText("Resultado: RUIM")
        } else if (valorTot >= 6 && valorTot < 7) {
            resultado.setText("Resultado: ABAIXO DA MÉDIA")
        } else if (valorTot >= 7 && valorTot < 8) {
            resultado.setText("Resultado: MEDIANO")
        } else if (valorTot >= 8 && valorTot < 9) {
            resultado.setText("Resultado: BOM")
        } else if (valorTot >= 9 && valorTot < 10) {
            resultado.setText("Resultado: MUITO BOM")
        } else if (valorTot == 10.0) {
            resultado.setText("Resultado: ÓTIMO")
        }

        val btMail = findViewById<Button>(R.id.buttonMail)
        btMail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Resultado da Pesquisa")
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Avaliação de qualidade do IBMEC: \n" + valorTot.toString() + "/10\n" + resultado.text.toString()
            )
            startActivity(intent)
        }
        val btCall = findViewById<ImageButton>(R.id.call)
        btCall.setOnClickListener {
            val telefone = "+5521999686042"
            val intent2 = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$telefone"))
            startActivity(intent2)
        }
    }
}