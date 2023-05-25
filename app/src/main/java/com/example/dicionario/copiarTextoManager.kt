package com.example.dicionario

import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class copiarTextoManager(private val container: ViewGroup, private val textView: TextView) {
    fun copiarTexto() {
        // Crea un StringBuilder para almacenar el texto de cada TextInputEditText
        val stringBuilder = StringBuilder()

        // Itera sobre todos los TextInputEditText en el contenedor
        for (i in 0 until container.childCount) {
            val child = container.getChildAt(i)
            if (child is TextInputEditText) {
                // Agrega el texto del TextInputEditText al StringBuilder
                val text = child.text.toString()
                stringBuilder.append("$text ")
            }
        }

        // Establece el texto del TextView como el texto acumulado de todos los TextInputEditText
        textView.text = stringBuilder.toString()
    }
}