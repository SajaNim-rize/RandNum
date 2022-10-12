package com.rand.randnum

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class RandViewModel(application: Application) : AndroidViewModel(application) {
    private val randRepository = RandRepository(application)
    private var randItems =
        randRepository.getTodoListAll()

    fun getTodoListAll(): LiveData<List<RandModel>> {
        return randItems
    }

    fun insert(randModel: RandModel) {
        randRepository.insert(randModel)
    }

    fun delete(randModel: RandModel) {
        randRepository.delete(randModel)
    }
}