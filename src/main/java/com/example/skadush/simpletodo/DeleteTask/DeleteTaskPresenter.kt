package com.example.skadush.simpletodo.DeleteTask

import android.content.Context
import com.example.skadush.simpletodo.Model.Todos

class DeleteTaskPresenter(private val deleteTaskRepository: IDeleteTaskRepository) : IDeleteTaskPresenter {
    override fun deleteTask(context: Context, todo: Todos, position: Int, refresh: (position: Int) -> Unit) {

    }

    override fun deleteTask(todo:Todos, context: Context, refresh: () -> Unit) {
        if(deleteTaskRepository.deleteTask(todo,context)){
            refresh()
        }
    }
}