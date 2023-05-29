package com.example.dicionario.controladorInput

import android.text.InputType
import android.view.View
import android.widget.LinearLayout
import com.google.android.material.textfield.TextInputEditText

class InputManager(private val container: LinearLayout) {

        private var inputCount = 0

        fun addNewInput() {
            val newInput = TextInputEditText(container.context)
            newInput.id = View.generateViewId()
            newInput.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
            newInput.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
            )
            inputCount++
            newInput.hint = "Sinonimo ${inputCount + 1}"
            container.addView(newInput)

        }
        fun deleteLastInput() {
            val lastInputIndex = container.childCount - 1
            if (lastInputIndex >= 0) {
                container.removeViewAt(lastInputIndex)
                inputCount--
            }
        }

}