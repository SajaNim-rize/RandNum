package com.rand.randnum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.rand.randnum.databinding.ActivityMainBinding
import java.lang.reflect.Array
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    var min = 0;
    var max = 0;
    var count = 0;

    private lateinit var randViewModel: RandViewModel

    private lateinit var randListAdapter: ListAdapter
    private val randItems: ArrayList<RandModel> = ArrayList()

    lateinit var randModel : RandModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculbtn.setOnClickListener(Button())
        binding.deletebtn.setOnClickListener(ButtonDelete())

        initViewModel()
        randListAdapter = ListAdapter(applicationContext, randItems)

    }

    private fun initViewModel() {
        randViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(RandViewModel::class.java)
        randViewModel.getListAll().observe(this, androidx.lifecycle.Observer {
            randListAdapter.setRandItems(it)
        })
    }

    inner class Button : OnClickListener{
        override fun onClick(p0: View?) {

            min = Integer.parseInt(binding.editMin.text.toString())
            max = Integer.parseInt(binding.editMax.text.toString())
            count = Integer.parseInt(binding.editCount.text.toString())

           CreateRandNum(min, max, count)
        }
    }

    inner class ButtonDelete : OnClickListener{
        override fun onClick(p0: View?) {
            randViewModel.delete(randModel)
        }
    }
    fun CreateRandNum(min : Int, max : Int, count : Int) {

        var id: Long? = null
        val check = binding.checkbox.isChecked

        val dataInt : kotlin.Array<Int> = Array(count, {0})
        val dataDouble : kotlin.Array<Double> = kotlin.Array(count, {0.0})

        for(i in 0 until count){
            dataInt[i] = Random.nextInt(max - min) + min
            dataDouble[i] = Random.nextDouble((max - min).toDouble()) + min.toDouble()
        }

        randModel = RandModel(
            id,
            min,
            max,
            count,
            check,
            dataInt.toString(),
            dataDouble.toString()
        )
        randViewModel.insert(randModel)

    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy!!!")
        randViewModel.delete(randModel)
    }
}