package com.example.skadush.simpletodo.DeleteTask

import android.content.Context
import com.example.skadush.simpletodo.Model.Todos

interface IDeleteTaskRepository {
    fun deleteTask(todo:Todos,context:Context):Boolean

}