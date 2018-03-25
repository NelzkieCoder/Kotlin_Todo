package com.example.skadush.simpletodo.AddTask

import android.content.Context
import com.example.skadush.simpletodo.Model.Todos

/**
 * Created by skadush on 19/03/18.
 */
interface IAddTaskRepository{

    fun addTask(newTask:Todos, context:Context) : Boolean
}