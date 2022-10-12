package com.rand.randnum

import android.app.Application
import androidx.lifecycle.LiveData

class RandRepository(application: Application) {
    private var randDatabase: RandDatabase = RandDatabase.getInstance(application)!!
    private var randDao: RandDao = randDatabase.randDao()
    private var randItems: LiveData<List<RandModel>> = randDao.getListAll()

    fun getTodoListAll(): LiveData<List<RandModel>> {
        return randItems
    }

    fun getIntRandNum(){

    }

    fun insert(todoModel: RandModel) {
        try {
            val thread =
                Thread(Runnable {
                    randDao.insert(todoModel)
                }).start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun delete(todoModel: RandModel) {
        try {
            val thread = Thread(Runnable {
                randDao.delete(todoModel)
            })
            thread.start()
        } catch (e: Exception) {
        }
    }

}