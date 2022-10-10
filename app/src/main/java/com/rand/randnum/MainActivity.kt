package com.rand.randnum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.rand.randnum.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    lateinit var btn : Button
    lateinit var arrayList: ArrayList<Int>
    lateinit var listView : ListView
    var min = 0;
    var max = 0;
    var count = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        min = Integer.parseInt(binding.editMin.text.toString())
        max = Integer.parseInt(binding.editMax.text.toString())
        count = Integer.parseInt(binding.editCount.text.toString())

        arrayList = CreateRandNum(min, max, count)
        
    }
    inner class Button : OnClickListener{
        override fun onClick(p0: View?) {

        }
    }
    fun CreateRandNum(min : Int, max : Int, count : Int): ArrayList<Int> {

    }
}