package com.example.dicionario

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.android.material.textfield.TextInputEditText

class textInputManager(private val context: Context, private val container: ViewGroup) {
    private var textInputCount = 0

    fun agregarTextInputEditText() {
        // Crea un nuevo TextInputEditText
        val newTextInputEditText = TextInputEditText(context)
        newTextInputEditText.hint = "Palabra ${textInputCount + 1}"

        // Establece un ID único para el nuevo TextInputEditText
        val newId = View.generateViewId()
        newTextInputEditText.id = newId

        // Agrega el nuevo TextInputEditText al contenedor
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        container.addView(newTextInputEditText, layoutParams)

        // Incrementa el contador
        textInputCount++
    }
}