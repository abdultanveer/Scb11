package com.example.scb11

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.scb11.data.Item
import com.example.scb11.data.ItemRepository

class MainViewmodel(private val repository: ItemRepository):ViewModel() {
    var TAG = MainViewmodel::class.java.simpleName

    var count = 0
    //i'll make this seconds observable

    var _seconds = MutableLiveData<Int>()
    //seconds observable

    val allItems: LiveData<List<Item>> = repository.allItems.asLiveData()

    lateinit var timer: CountDownTimer

    fun incrementCount(){
        count++
    }

    suspend fun getItemById(id: Int): LiveData<Item?> {
        return repository.getUserById(id).asLiveData()
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


class ItemViewModelFactory(private val repository: ItemRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewmodel::class.java)) {
            return MainViewmodel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
}
