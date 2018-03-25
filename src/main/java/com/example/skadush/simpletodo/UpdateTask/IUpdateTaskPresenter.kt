package com.example.skadush.simpletodo.UpdateTask

import android.content.Context
import com.example.skadush.simpletodo.Model.Todos

interface IUpdateTaskPresenter {
    fun updateTask(context:Context,todo:Todos,position:Int ,refresh:(position:Int)->Unit)
}