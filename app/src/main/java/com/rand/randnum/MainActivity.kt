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
import androidx.lifecycle.ViewModelProvider
import com.rand.randnum.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    lateinit var arrayList: ArrayList<Int>
    lateinit var listView : ListView
    var min = 0;
    var max = 0;
    var count = 0;

    private lateinit var randViewModel: RandViewModel

    private lateinit var randListAdapter: ListAdapter
    private val randItems: ArrayList<RandModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        min = Integer.parseInt(binding.editMin.text.toString())
        max = Integer.parseInt(binding.editMax.text.toString())
        count = Integer.parseInt(binding.editCount.text.toString())

        binding.calculbtn.setOnClickListener(Button())


    }

    private fun initViewModel() {
        randViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(RandViewModel::class.java)
        randViewModel.getTodoListAll().observe(this, androidx.lifecycle.Observer {
            randListAdapter.setTodoItems(it)
        })
    }

    inner class Button : OnClickListener{
        override fun onClick(p0: View?) {
            arrayList = CreateRandNum(min, max, count)

        }
    }
    fun CreateRandNum(min : Int, max : Int, count : Int): ArrayList<Int> {

    }
}