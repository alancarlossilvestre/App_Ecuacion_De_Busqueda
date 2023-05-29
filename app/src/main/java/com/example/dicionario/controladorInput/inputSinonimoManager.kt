package com.example.dicionario.controladorInput

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.dicionario.R
import com.google.android.material.textfield.TextInputEditText

class inputSinonimoManager (private val context: Context, private val layout: LinearLayout) {

    private var contadorSinonimos = 1

    fun agregarSinonimo() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val nuevoSinonimo = inflater.inflate(R.layout.palabras_y_sinonimos, null)
        val txtInputSinonimo = nuevoSinonimo.findViewById<TextInputEditText>(R.id.inputEditTextSinonimo)

        contadorSinonimos++
        txtInputSinonimo.hint = "Sinónimo $contadorSinonimos"

        layout.addView(nuevoSinonimo)
    }
}