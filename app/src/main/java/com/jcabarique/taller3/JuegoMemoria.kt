package com.jcabarique.taller3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_juego_memoria.*

class JuegoMemoria : AppCompatActivity() {
    var puntos: Int = 0
    var intentos: Int = 1
    var anterior: String = ""
    var anteriorView: String = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_memoria)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent: Intent =  Intent(this, MainActivity::class.java )
        intent.putExtra("puntoMemoria", 200)
        startActivity(intent)
        Log.d("myTag", "ddddddd atras");
    }


    fun onClickMostrar(view: View) {

        val tagView = view.getTag().toString().split("-")
        val tag = tagView[0]
        if(tag == anteriorView) {
            intentos = 1;
        }

        if (intentos % 2 == 0){
            if(tagView[1] == anterior) {
                mostrar(tag, "i_"+tagView[1])
                puntos += 100

            }else {
                mostrar(tag, "i_"+tagView[1])
                Handler().postDelayed({
                    ocultar(tag)
                    ocultar(anteriorView)
                }, 500)

            }
        }else {
            mostrar(tag, "i_"+tagView[1])
            anterior = tagView[1]
            anteriorView = tagView[0]
        }
        val puntaje: TextView = findViewById(R.id.puntaje)
        puntaje.text = "Puntos: " + puntos.toString()
        intentos += 1
    }



    fun mostrar (imgId: String, tag: String) {
        when (imgId){
            "1_1" -> {iv_11.setImageResource(getResources().getIdentifier(tag, "drawable", getPackageName()));}
            "1_2" -> {iv_12.setImageResource(getResources().getIdentifier(tag, "drawable", getPackageName()));}
            "1_3" -> {iv_13.setImageResource(getResources().getIdentifier(tag, "drawable", getPackageName()));}
            "1_4" -> {iv_14.setImageResource(getResources().getIdentifier(tag, "drawable", getPackageName()));}
            "2_1" -> {iv_21.setImageResource(getResources().getIdentifier(tag, "drawable", getPackageName()));}
            "2_2" -> {iv_22.setImageResource(getResources().getIdentifier(tag, "drawable", getPackageName()));}
            "2_3" -> {iv_23.setImageResource(getResources().getIdentifier(tag, "drawable", getPackageName()));}
            "2_4" -> {iv_24.setImageResource(getResources().getIdentifier(tag, "drawable", getPackageName()));}
            "3_1" -> {iv_31.setImageResource(getResources().getIdentifier(tag, "drawable", getPackageName()));}
            "3_2" -> {iv_32.setImageResource(getResources().getIdentifier(tag, "drawable", getPackageName()));}
            "3_3" -> {iv_33.setImageResource(getResources().getIdentifier(tag, "drawable", getPackageName()));}
            "3_4" -> {iv_34.setImageResource(getResources().getIdentifier(tag, "drawable", getPackageName()));}
        }
    }

    fun ocultar (tag: String) {
        when (tag){
            "1_1" -> {iv_11.setImageResource(R.drawable.signo1);}
            "1_2" -> {iv_12.setImageResource(R.drawable.signo1);}
            "1_3" -> {iv_13.setImageResource(R.drawable.signo1);}
            "1_4" -> {iv_14.setImageResource(R.drawable.signo1);}
            "2_1" -> {iv_21.setImageResource(R.drawable.signo1);}
            "2_2" -> {iv_22.setImageResource(R.drawable.signo1);}
            "2_3" -> {iv_23.setImageResource(R.drawable.signo1);}
            "2_4" -> {iv_24.setImageResource(R.drawable.signo1);}
            "3_1" -> {iv_31.setImageResource(R.drawable.signo1);}
            "3_2" -> {iv_32.setImageResource(R.drawable.signo1);}
            "3_3" -> {iv_33.setImageResource(R.drawable.signo1);}
            "3_4" -> {iv_34.setImageResource(R.drawable.signo1);}
        }
    }

    fun randomImg (tag: String, imgTag: String) {
        when (tag){
            "1_1" -> iv_11.setTag(tag + imgTag)
            "1_2" -> iv_12.setTag(tag + imgTag)
            "1_3" -> iv_13.setTag(tag + imgTag)
            "1_4" -> iv_14.setTag(tag + imgTag)
            "2_1" -> iv_21.setTag(tag + imgTag)
            "2_2" -> iv_22.setTag(tag + imgTag)
            "2_3" -> iv_23.setTag(tag + imgTag)
            "2_4" -> iv_24.setTag(tag + imgTag)
            "3_1" -> iv_31.setTag(tag + imgTag)
            "3_2" -> iv_32.setTag(tag + imgTag)
            "3_3" -> iv_33.setTag(tag + imgTag)
            "3_4" -> iv_34.setTag(tag + imgTag)
        }
        Log.d("myTag", iv_34.getTag().toString());
    }

    fun onClickReiniciar(view: View) {
        var arrayImgs: ArrayList<String> = arrayListOf("1_1", "1_2", "1_3", "1_4", "2_1", "2_2", "2_3", "2_4", "3_1", "3_2", "3_3", "3_4")
        var arrayTags: ArrayList<String> = arrayListOf("-1", "-2", "-3", "-5", "-2", "-3", "-4", "-6", "-1", "-5", "-6", "-4")


        var i: Int = 0;
        while (arrayTags.size != 0) {
            val random = Random(arrayTags.size - 1)
            val index: Int = random.random()
            randomImg(arrayImgs.get(i), arrayTags.get(index))

            arrayTags.removeAt(index)
            i+=1
        }

        intentos = 1
        iv_11.setImageResource(R.drawable.signo1)
        iv_12.setImageResource(R.drawable.signo1)
        iv_13.setImageResource(R.drawable.signo1)
        iv_14.setImageResource(R.drawable.signo1)
        iv_21.setImageResource(R.drawable.signo1)
        iv_22.setImageResource(R.drawable.signo1)
        iv_23.setImageResource(R.drawable.signo1)
        iv_24.setImageResource(R.drawable.signo1)
        iv_31.setImageResource(R.drawable.signo1)
        iv_32.setImageResource(R.drawable.signo1)
        iv_33.setImageResource(R.drawable.signo1)
        iv_34.setImageResource(R.drawable.signo1)
    }
}