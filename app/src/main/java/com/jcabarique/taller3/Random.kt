package com.jcabarique.taller3

class Random (val num: Int){

    fun random(): Int {
        return (0..num).random()
    }
}