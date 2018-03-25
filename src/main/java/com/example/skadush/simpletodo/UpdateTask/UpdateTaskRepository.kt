package com.example.skadush.simpletodo.UpdateTask

import android.content.Context
import com.example.skadush.simpletodo.Model.AppDataBase
import com.example.skadush.simpletodo.Model.Todos

class UpdateTaskRepository : IUpdateTaskRepository {
    override fun updateTask(todo: Todos, context: Context): Boolean {
        return try{
            val db = AppDataBase.getDatabaseBuiler(context)
            db.MyDAO().updateTodo(todo)
            true
        }catch (e:Exception){
            false
        }
    }


}