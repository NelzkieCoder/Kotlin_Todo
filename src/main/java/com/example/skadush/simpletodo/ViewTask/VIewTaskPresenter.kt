package com.example.skadush.simpletodo.ViewTask

import android.content.Context
import com.example.skadush.simpletodo.Model.Todos

class VIewTaskPresenter(private var viewTaskRepository: IViewTaskRepository) : IViewTaskPresenter {


    override fun viewTask(context: Context): List<Todos> {
        return viewTaskRepository.gettAllUsers(context)

    }


}