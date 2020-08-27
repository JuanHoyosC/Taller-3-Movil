package com.jcabarique.taller3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_game_two.*

class GameTwo : AppCompatActivity() {
    var n: Int = 2;
    var puntos: Int = 0;
    var arrayCasillasRandom : ArrayList<Int> = arrayListOf()
    var arrayJugador : ArrayList<Int> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_two)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent: Intent =  Intent(this, MainActivity::class.java )
        intent.putExtra("puntoGameTwo", 100)
        startActivity(intent)
    }



    fun mostrar () {
        arrayCasillasRandom.clear()
        val text: TextView = findViewById(R.id.textView4)
        text.text = "n: $n"
        var arrayCasillas: ArrayList<Int> = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25)
        var i: Int = 0;
        while (i < n){
                val random: Random = Random(arrayCasillas.size - 1)
                val index: Int = random.random()
                arrayCasillasRandom.add(arrayCasillas.get(index))
                arrayCasillas.removeAt(index)
            i+=1
        }


            i = 0
            while(i < arrayCasillasRandom.size) {
                iluminarCasilla(arrayCasillasRandom.get(i))
                i+=1
            }
        Handler().postDelayed({
            i = 0
            while(i < arrayCasillasRandom.size) {
                oscureserCasilla(arrayCasillasRandom.get(i))
                i+=1
            }
        }, 1500)
    }

    fun iluminarCasilla (casilla: Int) {
        when (casilla) {
            1 -> b1.setImageResource(R.drawable.background)
            2 -> b2.setImageResource(R.drawable.background)
            3 -> b3.setImageResource(R.drawable.background)
            4 -> b4.setImageResource(R.drawable.background)
            5 -> b5.setImageResource(R.drawable.background)
            6 -> b6.setImageResource(R.drawable.background)
            7 -> b7.setImageResource(R.drawable.background)
            8 -> b8.setImageResource(R.drawable.background)
            9 -> b9.setImageResource(R.drawable.background)
            10 -> b10.setImageResource(R.drawable.background)
            11 -> b11.setImageResource(R.drawable.background)
            12-> b12.setImageResource(R.drawable.background)
            13 -> b13.setImageResource(R.drawable.background)
            14 -> b14.setImageResource(R.drawable.background)
            15 -> b15.setImageResource(R.drawable.background)
            16 -> b16.setImageResource(R.drawable.background)
            17 -> b17.setImageResource(R.drawable.background)
            18 -> b18.setImageResource(R.drawable.background)
            19 -> b19.setImageResource(R.drawable.background)
            20 -> b20.setImageResource(R.drawable.background)
            21 -> b21.setImageResource(R.drawable.background)
            22 -> b22.setImageResource(R.drawable.background)
            23 -> b23.setImageResource(R.drawable.background)
            24 -> b24.setImageResource(R.drawable.background)
            25 -> b25.setImageResource(R.drawable.background)

        }
    }

    fun oscureserCasilla (casilla: Int) {
        when (casilla) {
            1 -> b1.setImageResource(R.drawable.h0969_swatch)
            2 -> b2.setImageResource(R.drawable.h0969_swatch)
            3 -> b3.setImageResource(R.drawable.h0969_swatch)
            4 -> b4.setImageResource(R.drawable.h0969_swatch)
            5 -> b5.setImageResource(R.drawable.h0969_swatch)
            6 -> b6.setImageResource(R.drawable.h0969_swatch)
            7 -> b7.setImageResource(R.drawable.h0969_swatch)
            8 -> b8.setImageResource(R.drawable.h0969_swatch)
            9 -> b9.setImageResource(R.drawable.h0969_swatch)
            10 -> b10.setImageResource(R.drawable.h0969_swatch)
            11 -> b11.setImageResource(R.drawable.h0969_swatch)
            12-> b12.setImageResource(R.drawable.h0969_swatch)
            13 -> b13.setImageResource(R.drawable.h0969_swatch)
            14 -> b14.setImageResource(R.drawable.h0969_swatch)
            15 -> b15.setImageResource(R.drawable.h0969_swatch)
            16 -> b16.setImageResource(R.drawable.h0969_swatch)
            17 -> b17.setImageResource(R.drawable.h0969_swatch)
            18 -> b18.setImageResource(R.drawable.h0969_swatch)
            19 -> b19.setImageResource(R.drawable.h0969_swatch)
            20 -> b20.setImageResource(R.drawable.h0969_swatch)
            21 -> b21.setImageResource(R.drawable.h0969_swatch)
            22 -> b22.setImageResource(R.drawable.h0969_swatch)
            23 -> b23.setImageResource(R.drawable.h0969_swatch)
            24 -> b24.setImageResource(R.drawable.h0969_swatch)
            25 -> b25.setImageResource(R.drawable.h0969_swatch)

        }
    }

    fun onClickComenzar(view: View) {
        mostrar()
    }

    fun onClickPush(view: View) {
        if(arrayJugador.size != arrayCasillasRandom.size) {
            arrayJugador.add(view.getTag().toString().toInt())
            iluminarCasilla(view.getTag().toString().toInt())
        }

        if(arrayJugador.size == arrayCasillasRandom.size) {

            var i: Int = 0
            Handler().postDelayed({
                i = 0
                while(i < arrayJugador.size) {
                    oscureserCasilla(arrayJugador.get(i))
                    i+=1
                }
            }, 500)

            Handler().postDelayed({

                val textPunto: TextView = findViewById(R.id.textView5)
                var suma: Int = 0
                for(num in 0..(arrayJugador.size - 1)) {
                    for (j in 0..(arrayCasillasRandom.size - 1)){
                        if(arrayJugador.get(num) == arrayCasillasRandom.get(j)){
                            suma++
                            Log.d("myTag", "Entro a la suma");
                        }
                    }
                }

                if(suma == arrayJugador.size){
                    puntos+= n*50
                    n+=1

                    imageView2.setImageResource(R.drawable.gano)
                    textPunto.text = "Puntos: $puntos"
                    mostrar()
                    arrayJugador.clear()
                }else{
                    imageView2.setImageResource(R.drawable.perdio)
                    n = 2
                    mostrar()
                    imageView2.setImageResource(R.drawable.perdio)
                    arrayJugador.clear()
                }
            }, 1500)


        }

    }
}