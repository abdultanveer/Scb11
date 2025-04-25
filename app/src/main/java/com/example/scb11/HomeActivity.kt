package com.example.scb11

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.scb11.network.MarsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

class HomeActivity : AppCompatActivity() {
    var homeTv: TextView? = null
    var contactEt: EditText? = null
    lateinit var adapter:WordListAdapter
lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homeTv = findViewById(R.id.tvHome)
        contactEt = findViewById(R.id.etContact)
        recyclerView = findViewById(R.id.recyclerView)
        adapter = WordListAdapter()
        recyclerView.layoutManager =  LinearLayoutManager(this)
        recyclerView.adapter = adapter
        //        String myName = getIntent().getExtras().getString("name");
//        homeTv.setText(myName);
    }

    override fun onStart() {
        super.onStart()
        getContact(null)
    }



    fun getContact(view: View?) {
//        String con = contactEt.getText().toString();
//        homeTv.setText(con);
        GlobalScope.launch(Dispatchers.Main) {
            val listResult = try {
            MarsApi.retrofitService.getPhotos()
        } catch (e: IOException) {
            TODO("Not yet implemented")
        }
            adapter.submitList(listResult)
//            var imageView:ImageView = findViewById(R.id.imageView)
//            imageView.load(listResult.get(0).imgSrc)
            Log.i("homeactivity","id--"+listResult.get(0).id+"url--"+listResult.get(0).imgSrc)

        }
    }
}