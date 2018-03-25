package com.example.skadush.simpletodo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.example.skadush.simpletodo.AddTask.AddTaskPresenter
import com.example.skadush.simpletodo.AddTask.AddTaskRepository
import com.example.skadush.simpletodo.AddTask.IAddTaskRepository
import com.example.skadush.simpletodo.DeleteTask.DeleteTaskPresenter
import com.example.skadush.simpletodo.DeleteTask.DeleteTaskRepository
import com.example.skadush.simpletodo.DeleteTask.IDeleteTaskRepository
import com.example.skadush.simpletodo.Model.Todos
import com.example.skadush.simpletodo.UpdateTask.IUpdateTaskRepository
import com.example.skadush.simpletodo.UpdateTask.UpdateTaskPresenter
import com.example.skadush.simpletodo.UpdateTask.UpdateTaskRepository
import com.example.skadush.simpletodo.ViewTask.IViewTaskRepository
import com.example.skadush.simpletodo.ViewTask.VIewTaskPresenter
import com.example.skadush.simpletodo.ViewTask.ViewTaskRepository
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.editText
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var addTaskButton:Button
    lateinit var editName:EditText
    private lateinit var addTaskPresenter:AddTaskPresenter
    private lateinit var viewTaskPresenter: VIewTaskPresenter
    private lateinit var deleteTaskPresenter: DeleteTaskPresenter
    private lateinit var updateTaskPresenter: UpdateTaskPresenter
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var addTaskRepository:IAddTaskRepository = AddTaskRepository()
        addTaskPresenter = AddTaskPresenter(addTaskRepository)

        var viewTaskRepository:IViewTaskRepository = ViewTaskRepository()
        viewTaskPresenter = VIewTaskPresenter(viewTaskRepository)

        var deleteTaskRepository:IDeleteTaskRepository = DeleteTaskRepository()
        deleteTaskPresenter = DeleteTaskPresenter(deleteTaskRepository)

        var updateTaskRepository:IUpdateTaskRepository = UpdateTaskRepository()
        updateTaskPresenter = UpdateTaskPresenter(updateTaskRepository)


        val reverseList:List<Todos> = viewTaskPresenter.viewTask(this)
        Collections.reverse(reverseList)

        recyclerViewAdapter = RecyclerViewAdapter(reverseList, {
            deleteTaskPresenter.deleteTask(it,this){
                refreshAdapter()
            }
        }){todo,position ->
             var task:String? = null
            var edittext:EditText? = null
            val dialog:MaterialDialog = MaterialDialog.Builder(this)
                    .title("Task")
                    .customView(R.layout.custom_dialog, true)
                    .positiveText("Update")
                    .onPositive({ dialog, which ->
                        task = edittext?.text.toString()
                        todo.task = task
                        updateTaskPresenter.updateTask(this,todo,position){
                            toast("${todo.task}")
                            recyclerViewAdapter.notifyItemChanged(position)
                        }
                    })
                    .show()

            val view:View? = dialog.customView
            edittext = view?.findViewById(R.id.editText)
            edittext?.setText(todo.task)
            task = edittext?.text.toString()



        }
        recyclerView.adapter = recyclerViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }



    fun addTask(view : View){
        //addTaskPresenter.addTask(editTextTask.text.toString(),{ it -> toast(it)})
        addTaskPresenter.addTask(applicationContext, Todos(editTextTask.text.toString(), Date(),false)){

            refreshAdapter()
        }
    }



    private fun refreshAdapter() {
        val reverseList: List<Todos> = viewTaskPresenter.viewTask(this)
        Collections.reverse(reverseList)
        recyclerViewAdapter.results = reverseList
        recyclerViewAdapter.notifyDataSetChanged()
    }
}
