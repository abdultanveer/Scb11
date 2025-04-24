package com.example.scb11

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LangsAdapter(var languages: Array<String>) :RecyclerView.Adapter<LViewHolder>() {
var TAG = LangsAdapter::class.java.simpleName
  lateinit  var context:Context
    //meeraj -- bought a visiting card
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LViewHolder {
        Log.i(TAG,"meeraj bought a visiting card and gave it to hrishikesh")
        //inflating the xml
        context = parent.context
        var visitingCard = LayoutInflater.from(parent.context).inflate(R.layout.visiting_card,parent,false)
        return LViewHolder(visitingCard)
    }
//context  == history

    //asha writing data on visiting card
    override fun onBindViewHolder(hrishiholder: LViewHolder, position: Int) {
        Log.i(TAG,"asha is writig --"+languages.get(position))
        hrishiholder.visitingCardTv.setText(languages.get(position))
    }

    //madhavi -- no of items in dataset
    override fun getItemCount(): Int {
        Log.i(TAG,"madhavi counted --"+languages.size)
      return  languages.size
    }
}

//hrishikesh --visiting card holder[reserve cards]
class LViewHolder(vCard: View):RecyclerView.ViewHolder(vCard) {
init {
    Log.i("Adapter","vc holder --hrishikesh got the card bought by meeraj")
}
    var visitingCardTv: TextView = vCard.findViewById(R.id.tvVisitingCard)


}
