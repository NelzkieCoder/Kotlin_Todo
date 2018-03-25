package com.example.skadush.simpletodo.ViewTask

import android.content.Context
import com.example.skadush.simpletodo.Model.Todos

interface IViewTaskPresenter {

    fun viewTask(context:Context) : List<Todos>
}