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

    fun insert(todoModel: RandModel) {
        try {
            val thread =
                Thread(Runnable {  //별도 스레드를 통해 Room 데이터에 접근해야한다. 연산 시간이 오래 걸리는 작업은 메인 쓰레드가 아닌 별도의 쓰레드에서 하도록 되어있다. 그렇지 않으면 런타임에러 발생.
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