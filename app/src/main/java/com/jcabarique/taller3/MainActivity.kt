package com.jcabarique.taller3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val score: TextView = findViewById(R.id.textView6)
        val puntoGameTwo = intent.getStringExtra("puntoGameTwo")
        val puntoMemoria = intent.getStringExtra("puntoMemoria")
        Log.d("myTag", intent.getStringExtra("puntoGameTwo").toString());
        Log.d("myTag1", intent.getStringExtra("puntoMemoria").toString());
        if (puntoGameTwo == null && puntoMemoria == null){
            score.text = "Score: 0"
        }else{

            if(puntoGameTwo != null && puntoMemoria != null){
                score.text = "Score: " + (puntoGameTwo.toString().toInt() + puntoMemoria.toString().toInt()).toString()
            }else{
                if(puntoGameTwo != null){
                    score.text = "Score: $puntoGameTwo"
                }else {
                    if(puntoMemoria != null){
                        score.text = "Score: $puntoMemoria"
                    }
                }
            }

        }




        buttonA.setOnClickListener {
            val intent: Intent = Intent(this, JuegoMemoria::class.java)
            startActivity(intent)

        }

        buttonB.setOnClickListener {
            val intent: Intent = Intent(this, GameTwo::class.java)
            startActivity(intent)
        }
    }
}