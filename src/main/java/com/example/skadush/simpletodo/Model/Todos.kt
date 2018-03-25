package com.example.skadush.simpletodo.Model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.example.skadush.simpletodo.Utility.Converters
import com.example.skadush.simpletodo.Utility.DateConverter
import java.util.*

@Entity(tableName = "Todo")
class Todos(task: String, dateTime: Date, var checked: Boolean = false) {


    @PrimaryKey(autoGenerate = true)
    var id:Long = 0

    var task:String? = task

    @TypeConverters(Converters::class)
    var dateTime:Date? = dateTime


}