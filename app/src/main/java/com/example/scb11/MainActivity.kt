package com.example.scb11

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.scb11.data.Item
import com.example.scb11.data.ItemDao
import com.example.scb11.data.ItemRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

//NEFT - account no-ifsc code,
//transfer -- mobile no/email address[UPI]
//server --map upi id /mobile no  to the account no and ifsc code NPCI

class MainActivity : AppCompatActivity() {
    var TAG = MainActivity::class.java.simpleName
    lateinit var incrementTextView: TextView
    lateinit var viewModel: MainViewmodel

    lateinit var dao: ItemDao

    var secsObserver : Observer<Int> = object :Observer<Int>{
        override fun onChanged(value: Int) {
            //receiving the update/notification
        incrementTextView.setText(value.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewmodel::class.java]
        viewModel._seconds.observe(this, secsObserver);  //registering phno/subscribe button/bellicon/
        incrementTextView = findViewById(R.id.tvIncrement)
        incrementTextView.setText(""+viewModel._seconds)

        var  database = ItemRoomDatabase.getDatabase(this)
        dao = database.itemDao()
        //R.java --maps names to nos -Register-layout/phnos/name-phno   abdul-9880979732
        //R.phnos.abdul

        Log.i(TAG,"egg-created-mem allocated")

    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG,"hatched-started-visble-handling clicks")
       var c =  add(10,20)

    }

    private fun add(i: Int, i1: Int):Int {
        var c = 10
        repeat(5){
            c+=5
        }
        var d = c*10-i+45
        return i+i1+c
    }


    override fun onResume() {
        super.onResume()
        Log.w(TAG,"wokenup-resumed--restore app state")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG,"sleep-paused--store app state")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"hibernated--stopped--release resources")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"destroyed--cleanup")

    }

    fun handleSignin(view: View) {
        //startHome()
        //https://developer.android.com/guide/components/intents-common
        var dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345678")) //implicit intent
        startActivity(dialIntent)
        throw NullPointerException("crash demo")

    }

    private fun startHome() {
        Log.i("MainActivity", "signing in....")
        var data = "abdul ansari"
        var hIntention = Intent(this, HomeActivity::class.java)//explicit intent
        hIntention.putExtra("name", data)
        startActivity(hIntention)
    }



    fun incrementCount(view: View) {
        viewModel.startTimer()

       // viewModel.incrementCount()
        //incrementTextView.setText(""+viewModel._seconds)
    }

    fun insertDb(view: View) {
        var item = Item(11,"fruits",11.11,111)
        GlobalScope.launch {
            dao.insert(item)
        }
    }

    fun getData(view: View) {
        GlobalScope.launch(Dispatchers.Main) {
            var item = dao.getItems().first()

            incrementTextView.setText(item.toString())
        }
    }
}