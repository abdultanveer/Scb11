package com.example.scb11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {
    var languages = arrayOf("ennglish","hindi","kannnada","urdu","telgu",
        "ennglish","hindi","kannnada","urdu","telgu",
        "ennglish","hindi","kannnada","urdu","telgu",
        "ennglish","hindi","kannnada","urdu","telgu",
        "ennglish","hindi","kannnada","urdu","telgu",
        "ennglish","hindi","kannnada","urdu","telgu",
        "ennglish","hindi","kannnada","urdu","telgu",
        "ennglish","hindi","kannnada","urdu","telgu",
        "ennglish","hindi","kannnada","urdu","telgu")
  lateinit  var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler) //inflated--


        recyclerView = findViewById(R.id.recyclerView)

        var ladapter:LangsAdapter = LangsAdapter(languages)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter  = ladapter

    }
}