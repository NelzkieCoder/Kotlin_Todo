package com.example.skadush.simpletodo.ViewTask

import android.content.Context
import com.example.skadush.simpletodo.Model.AppDataBase
import com.example.skadush.simpletodo.Model.Todos

class ViewTaskRepository : IViewTaskRepository {
    override fun gettAllUsers(context: Context): List<Todos> {

        val db = AppDataBase.getDatabaseBuiler(context)

        return db.MyDAO().getAllUsers()
    }


}