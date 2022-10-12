package com.rand.randnum

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_cal")
data class RandModel(
    @PrimaryKey(autoGenerate = true)  //@PrimaryKey 의 autoGenerate = : null 을 받으면 id 값을 자동으로 할당해준다
    var id: Long?,

    @ColumnInfo(name = "min")
    var min: Int,

    @ColumnInfo(name = "max")
    var max: Int,

    @ColumnInfo(name = "count")
    var count: Int,

    @ColumnInfo(name = "check")
    var check: Boolean,

    @ColumnInfo(name = "createcalInt")
    var createcal: String,

    @ColumnInfo(name = "createcalDouble")
    var createcalDouble: String
) {
    constructor() : this(null, 0, 0, 0, false, "", "")
}

