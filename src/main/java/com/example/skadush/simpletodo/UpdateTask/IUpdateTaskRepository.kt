package com.example.skadush.simpletodo.UpdateTask

import android.content.Context
import com.example.skadush.simpletodo.Model.Todos

interface IUpdateTaskRepository {
    fun updateTask(todo:Todos,context:Context):Boolean
}