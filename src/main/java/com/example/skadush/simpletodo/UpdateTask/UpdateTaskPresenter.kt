package com.example.skadush.simpletodo.UpdateTask

import android.content.Context
import com.example.skadush.simpletodo.Model.Todos

class UpdateTaskPresenter(private var updateTaskRepository: IUpdateTaskRepository):IUpdateTaskPresenter {
    override fun updateTask(context: Context, todo: Todos, position: Int, refresh: (position: Int) -> Unit) {
        if(updateTaskRepository.updateTask(todo,context)){
            refresh(position)
        }
    }
}