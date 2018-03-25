package com.example.skadush.simpletodo.ViewTask

import android.content.Context
import com.example.skadush.simpletodo.Model.Todos

interface IViewTaskRepository {

    fun gettAllUsers(context:Context):List<Todos>
}