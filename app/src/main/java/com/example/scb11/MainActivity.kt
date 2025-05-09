package com.example.scb11

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

//NEFT - account no-ifsc code,
//transfer -- mobile no/email address[UPI]
//server --map upi id /mobile no  to the account no and ifsc code NPCI

class MainActivity : AppCompatActivity() {
    var TAG = MainActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
}