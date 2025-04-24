package com.example.scb11

import androidx.lifecycle.ViewModel

class MainViewmodel:ViewModel() {
    var count = 0


    fun incrementCount(){
        count++
    }
}