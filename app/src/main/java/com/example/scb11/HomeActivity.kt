package com.example.scb11

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.scb11.network.MarsApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    var homeTv: TextView? = null
    var contactEt: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homeTv = findViewById(R.id.tvHome)
        contactEt = findViewById(R.id.etContact)

        //        String myName = getIntent().getExtras().getString("name");
//        homeTv.setText(myName);
    }

    fun getContact(view: View?) {
//        String con = contactEt.getText().toString();
//        homeTv.setText(con);
        GlobalScope.launch {
            val listResult = MarsApi.retrofitService.getPhotos()
            Log.i("homeactivity",listResult.toString())

        }
    }
}