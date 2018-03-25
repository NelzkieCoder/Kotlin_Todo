package com.example.skadush.simpletodo.DeleteTask

import android.content.Context
import com.example.skadush.simpletodo.Model.AppDataBase
import com.example.skadush.simpletodo.Model.Todos

class DeleteTaskRepository : IDeleteTaskRepository {
    override fun deleteTask(todo: Todos, context: Context): Boolean {
        val db = AppDataBase.getDatabaseBuiler(context)
        return try {
            db.MyDAO().deleteTodo(todo)
            true
        }catch (e:Exception){
            false
        }
    }


}