package com.rand.randnum

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class ListAdapter (val context : Context, val arrayList : ArrayList<RandModel>) : BaseAdapter()

{

    private var randItems: List<RandModel> = listOf()

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(p0: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(p0: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.activity_main, null)




        return view
    }


    fun setRandItems(randItems: List<RandModel>) {
        this.randItems = randItems
        Log.d("MainActivity", "randItem setTodoItems !!: " + randItems.size);
        notifyDataSetChanged()
    }

}