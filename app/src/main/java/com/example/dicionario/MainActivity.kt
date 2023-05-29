package com.example.dicionario

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.example.dicionario.controladorInput.InputManager
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var copiarTextoManager: copiarTextoManager
    private lateinit var linearLayout: LinearLayout
    private lateinit var btnAgregar: Button


    private lateinit var btnAdd : AppCompatImageView
    private var contadorP = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayout = findViewById(R.id.linearLayoutMain)
        btnAgregar = findViewById(R.id.btnAgregarPalabramain)

        btnAgregar.setOnClickListener {
            agregarElemento()
        }
    }

    fun generarEcuacion(view: View) {

    }

    private fun agregarElemento(){
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val nuevoElemento = inflater.inflate(R.layout.palabras_y_sinonimos, null)
        val txtInputPalabra =  nuevoElemento.findViewById<TextInputEditText>(R.id.palabra_1)
        val txtInputSinonimo =  nuevoElemento.findViewById<TextInputEditText>(R.id.inputEditTextSinonimo)
        btnAdd =  nuevoElemento.findViewById(R.id.addS)

        contadorP++
        txtInputPalabra.hint = "Palabra $contadorP"
        txtInputSinonimo.hint = "Sinonimo"

        linearLayout.addView(nuevoElemento)
    }

}