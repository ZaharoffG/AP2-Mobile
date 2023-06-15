package com.example.reviewapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class UsuarioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_usuario, container, false)
        val userView: TextView = view.findViewById(R.id.user)
        val emailView: TextView = view.findViewById(R.id.email)
        val dataView: TextView = view.findViewById(R.id.data)

        val user = arguments?.getString("nome")
        val email = arguments?.getString("email")
        val data = arguments?.getString("data")

        userView.setText ("usuario: " + user)
        emailView.setText("email: " + email)
        dataView.setText("data: " + data)


        return view
    }

}