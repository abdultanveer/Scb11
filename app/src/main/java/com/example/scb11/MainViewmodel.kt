package com.example.scb11

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewmodel:ViewModel() {
    var TAG = MainViewmodel::class.java.simpleName

    var count = 0
    //i'll make this seconds observable

    var _seconds = MutableLiveData<Int>()
    //seconds observable
    lateinit var timer: CountDownTimer

    fun incrementCount(){
        count++
    }

    fun startTimer(){
        timer = object :CountDownTimer(10_000,1_000){
            override fun onTick(timeRemaining: Long) {
                _seconds.value = timeRemaining.toInt()
                Log.i(TAG,"time remaininng --"+_seconds)

            }

            override fun onFinish() {
                Log.i(TAG,"timer finnished")
            }

        }.start()

    }
}