package com.example.skadush.simpletodo.AddTask

import android.content.Context
import com.example.skadush.simpletodo.Model.AppDataBase
import com.example.skadush.simpletodo.Model.Todos
import io.realm.Realm

/**
 * Created by skadush on 19/03/18.
 */
class AddTaskRepository : IAddTaskRepository {

    override fun addTask(newTask: Todos, context: Context): Boolean {
        val db = AppDataBase.getDatabaseBuiler(context)
        db.MyDAO().saveData(newTask)

        return try {
            true
        }catch (e: Exception){
            false
        }
    }



}