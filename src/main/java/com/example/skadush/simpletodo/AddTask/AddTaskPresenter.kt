package com.example.skadush.simpletodo.AddTask

/**
 * Created by skadush on 19/03/18.
 */
import android.arch.persistence.room.Room
import android.content.Context
import com.example.skadush.simpletodo.Model.AppDataBase
import com.example.skadush.simpletodo.Model.Migrations
import com.example.skadush.simpletodo.Model.Todos
import io.realm.log.RealmLog.debug
import org.jetbrains.anko.toast
class AddTaskPresenter(var taskRepository: IAddTaskRepository) : IAddTaskPresenter {



    override fun addTask(context: Context, newTask: Todos, result: () -> Unit) {

        val MIGRATION_1_2 = Migrations()
        //val db:AppDataBase = Room.databaseBuilder(context,AppDataBase::class.java,"Tasks").addMigrations(MIGRATION_1_2).allowMainThreadQueries().build()
        //val db = AppDataBase.getDatabaseBuiler(context)

        taskRepository.addTask(newTask,context).let {
            result()
        }


    }

    override fun addTask(newTask: String, ss: (String) -> Unit) {
       ss(newTask)
    }








}