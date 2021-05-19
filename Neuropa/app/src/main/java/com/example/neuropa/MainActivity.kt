package com.example.neuropa

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var tablaresp = listOf(R.id.respuesta1,R.id.respuesta2,R.id.respuesta3,R.id.respuesta4)
    var i=0
    var mapa: HashMap<String, String> = HashMap<String, String>()
    var puesta =false
    var definitiva=""
    var puntuacion=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mapa.put("Noruega", "Oslo")
        mapa.put("Letonia", "Riga")
        mapa.put("España", "Madrid")
        mapa.put("Francia", "París")
        mapa.put("Alemania", "Berlín")
        mapa.put("Portugal", "Lisboa")
        mapa.put("Italia", "Roma")
        mapa.put("Rusia", "Moscú")
        mapa.put("Bélgica", "Bruselas")
        mapa.put("Bulgaria", "Sofía")
        var respuestas: Array<String> = resources.getStringArray(R.array.respuestas)
        val listpais = arrayListOf<String>()
        var seleccionado=""
        var vuelta=0
        rdgp.clearCheck()
        respuesta1.visibility = View.GONE
        respuesta2.visibility = View.GONE
        respuesta3.visibility = View.GONE
        respuesta4.visibility = View.GONE


        btn_otropais.setOnClickListener {
            enunbot.setText("Mostrar otro País")
            respuesta1.visibility = View.VISIBLE
            respuesta2.visibility = View.VISIBLE
            respuesta3.visibility = View.VISIBLE
            respuesta4.visibility = View.VISIBLE

            if (respuesta1.isChecked==true){
                seleccionado= respuesta1.text as String
                if(seleccionado.equals(definitiva)){
                    Toast.makeText(applicationContext,"CORRECTO",
                            Toast.LENGTH_SHORT).show()
                    puntuacion++

                    rdgp.clearCheck()
                }
                rdgp.clearCheck()
            }
            if (respuesta2.isChecked==true){
                seleccionado= respuesta2.text as String
                if(seleccionado.equals(definitiva)){
                    Toast.makeText(applicationContext,"CORRECTO",
                            Toast.LENGTH_SHORT).show()
                    puntuacion++
                    rdgp.clearCheck()
                }
                rdgp.clearCheck()
            }
            if (respuesta3.isChecked==true){
                seleccionado= respuesta3.text as String
                if(seleccionado.equals(definitiva)){
                    Toast.makeText(applicationContext,"CORRECTO",
                            Toast.LENGTH_SHORT).show()
                    puntuacion++
                    rdgp.clearCheck()
                }
                rdgp.clearCheck()
            }
            if (respuesta4.isChecked==true){
                seleccionado= respuesta4.text as String
                if(seleccionado.equals(definitiva)){

                    
                    Toast.makeText(applicationContext,"CORRECTO",
                            Toast.LENGTH_SHORT).show()
                    puntuacion++
                    rdgp.clearCheck()
                }
                rdgp.clearCheck()
            }

            puesta = false
            i=0
            val aleatorio = java.util.Random()
            var pais = mapa.entries.elementAt(aleatorio.nextInt(mapa.size))
            if (listpais.size != mapa.size) {
                while (listpais.contains(pais.key)){
                pais =mapa.entries.elementAt(aleatorio.nextInt(mapa.size))
                }
                listpais.add(pais.key)
                paises.setText(pais.key)
            }else
            {
                Toast.makeText(applicationContext,""+mapa.size+" paises " +puntuacion+" aciertos "+ (mapa.size-puntuacion)+" fallos",
                        Toast.LENGTH_LONG).show()

            }


            // val pais : TextView = findViewById(R.id.paises) as TextView
            // pais.setText(R.string.pregunta)

            val lista: List<String> = respuestas.toList()
            Collections.shuffle(lista)
            val respuestas2 = lista.toTypedArray()
            val aleat = java.util.Random()
            val posicion = aleat.nextInt(4)

            val verdadera = mapa.get(pais.key)
            if (verdadera != null)
            {
                definitiva = verdadera
            }

            if(vuelta<mapa.size)
            {
                for (num in tablaresp)
                {

                    if (respuestas2[i] == verdadera) {
                        val resp: RadioButton = findViewById(num) as RadioButton
                        resp.setText(String.format(verdadera))
                        puesta = true

                    } else {
                        val resp: RadioButton = findViewById(num) as RadioButton
                        resp.setText(String.format(respuestas2[i]))

                    }

                    i++
                }

                val id = tablaresp[posicion]

                if (puesta == false) {
                    val resp: RadioButton = findViewById(id) as RadioButton
                    resp.setText(verdadera.toString())

                }
                vuelta++



            }else{
                print(listpais.size)
                print(mapa.size)
            }


        }
    }



}




