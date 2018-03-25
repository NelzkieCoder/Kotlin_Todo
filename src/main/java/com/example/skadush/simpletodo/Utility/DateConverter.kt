package com.example.skadush.simpletodo.Utility

import android.annotation.SuppressLint
import android.arch.persistence.room.TypeConverter

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object DateConverter {

    @SuppressLint("SimpleDateFormat")
    var df: DateFormat = SimpleDateFormat(Constants.TIME_STAMPS)

    @TypeConverter
    fun fromTimeStamp(value:String):Date{
        return value?.let {
            return df.parse(value)
        }
    }

}


