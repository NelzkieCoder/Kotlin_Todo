package com.example.skadush.simpletodo.DeleteTask

import android.content.Context
import com.example.skadush.simpletodo.Model.Todos

interface IDeleteTaskPresenter {
    fun deleteTask(todo:Todos,context:Context, refresh : () -> Unit)


}