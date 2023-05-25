package com.example.dicionario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var textInputEditTextManager: textInputManager
    private lateinit var copiarTextoManager: copiarTextoManager

    private lateinit var textInputContainer: ViewGroup
    private lateinit var textoAcumuladoTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textInputContainer = findViewById(R.id.textInputContainer)
        textoAcumuladoTextView = findViewById(R.id.textoAcumuladoTextView)

        textInputEditTextManager = textInputManager(this, textInputContainer)
        copiarTextoManager = copiarTextoManager(textInputContainer, textoAcumuladoTextView)


    }

    fun agregarTextInputEditText(view: View) {
        textInputEditTextManager.agregarTextInputEditText()
    }

    fun copiarTexto(view: View) {
        copiarTextoManager.copiarTexto()
    }



}