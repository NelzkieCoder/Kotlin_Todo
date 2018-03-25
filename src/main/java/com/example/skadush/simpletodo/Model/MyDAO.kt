package com.example.skadush.simpletodo.Model

import android.arch.persistence.room.*

@Dao
interface MyDAO {

    @Insert
    fun saveData( Todo:Todos)

    @Query("Select * from Todo")
    fun getAllUsers():List<Todos>

//    @Delete
//    fun deleteTodo(id:Long)

    @Delete
    fun deleteTodo(todo:Todos)

    @Update
    fun updateTodo(todo:Todos)


}