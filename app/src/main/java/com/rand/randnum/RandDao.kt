package com.rand.randnum

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RandDao {
    @Query("SELECT * FROM tb_cal ORDER BY min ASC")
    fun getListAll(): LiveData<List<RandModel>>  //getAll 함수에 LiveData 를 반환

    @Insert(onConflict = OnConflictStrategy.REPLACE)  //@Insert 의 onConflict = : 중복된 데이터의 경우 어떻게 처리할 것인지에 대한 처리를 지정
    fun insert(todo: RandModel)

    @Delete
    fun delete(rand : RandModel)

    @Query("SELECT createcalInt FROM tb_cal")
    fun getInt()
}