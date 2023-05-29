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
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var copiarTextoManager: copiarTextoManager
    private lateinit var linearLayout: LinearLayout
    private lateinit var btnAgregar: Button
    private lateinit var txtPalabrasSinonimos: TextView


    private lateinit var btnAddS : AppCompatImageView
    private lateinit var btnDeleteS :AppCompatImageView
    private var contadorP = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayout = findViewById(R.id.linearLayoutMain)
        btnAgregar = findViewById(R.id.btnAgregarPalabramain)

        txtPalabrasSinonimos = findViewById(R.id.txtPalabrasSinonimos)

        btnAgregar.setOnClickListener {
            agregarElemento()
        }

        val btnGenerar = findViewById<Button>(R.id.btnUnirPalabrasSinonimos)
        btnGenerar.setOnClickListener {
            generarTextoPalabrasSinonimos()
        }

    }

    fun generarEcuacion(view: View) {

    }

    private fun agregarElemento() {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val nuevoElemento = inflater.inflate(R.layout.palabras_y_sinonimos, null)
        val txtInputPalabra = nuevoElemento.findViewById<TextInputEditText>(R.id.palabra_1)
        val txtInputSinonimoContainer = nuevoElemento.findViewById<LinearLayout>(R.id.textInputSinonimoContainer)
        btnAddS = nuevoElemento.findViewById(R.id.addS)
        btnDeleteS = nuevoElemento.findViewById(R.id.quitarS)

        contadorP++
        txtInputPalabra.hint = "Palabra $contadorP"

        agregarSinonimo(txtInputSinonimoContainer) // Agregar el primer TextInputEditText de sinónimo

        btnAddS.setOnClickListener {
            agregarSinonimo(txtInputSinonimoContainer) // Agregar más TextInputEditText de sinónimos al presionar el botón
        }

        btnDeleteS.setOnClickListener {
            eliminarSinonimo(txtInputSinonimoContainer) // Eliminar el último TextInputEditText de sinónimo al presionar el botón
        }

        linearLayout.addView(nuevoElemento)
    }

    private fun agregarSinonimo(txtInputSinonimoContainer: LinearLayout) {
        val nuevoSinonimo = TextInputEditText(this)
        nuevoSinonimo.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        nuevoSinonimo.hint = "Sinónimo ${txtInputSinonimoContainer.childCount + 1}"
        txtInputSinonimoContainer.addView(nuevoSinonimo)
    }

    private fun eliminarSinonimo(txtInputSinonimoContainer: LinearLayout) {
        val childCount = txtInputSinonimoContainer.childCount
        if (childCount > 1) { // Verificar si hay más de un TextInputEditText de sinónimo para eliminar
            txtInputSinonimoContainer.removeViewAt(childCount - 1) // Eliminar el último TextInputEditText de sinónimo
        }
    }


    private fun generarTextoPalabrasSinonimos() {
        val sb = StringBuilder()

        for (i in 0 until linearLayout.childCount) {
            val elemento = linearLayout.getChildAt(i)
            val txtInputPalabra = elemento.findViewById<TextInputEditText>(R.id.palabra_1)
            val txtInputSinonimoContainer = elemento.findViewById<LinearLayout>(R.id.textInputSinonimoContainer)

            val palabra = txtInputPalabra.text.toString().trim()

            sb.append("Palabra: $palabra\n")

            for (j in 0 until txtInputSinonimoContainer.childCount) {
                val txtInputSinonimo =
                    txtInputSinonimoContainer.getChildAt(j) as? TextInputEditText
                val sinonimo = txtInputSinonimo?.text.toString().trim()
                if (sinonimo.isNotEmpty()) {
                    sb.append("   Sinónimo: $sinonimo\n")
                }
            }

            sb.append("\n")
        }

        txtPalabrasSinonimos.text = sb.toString()
    }

}