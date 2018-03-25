package com.example.skadush.simpletodo

import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.afollestad.materialdialogs.MaterialDialog
import com.example.skadush.simpletodo.Model.Todos
import kotlinx.android.synthetic.main.custom_layout.view.*

class RecyclerViewAdapter(var results: List<Todos>, val itemClick: (Todos) -> Unit, val showDialog:(todo:Todos,position:Int)->Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {

        var layoutInflater: View = LayoutInflater.from(parent?.context).inflate(R.layout.custom_layout, parent, false)

        return MyViewHolder(layoutInflater, itemClick,showDialog)

    }

    override fun getItemCount(): Int {

        return results.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

        val myViewHolder = holder as MyViewHolder

        myViewHolder.bindTask(results[position])
        myViewHolder.checkChangeListener(results[position])


    }

    class MyViewHolder(itemView: View?, val itemCLick: (Todos) -> Unit, val showDialog: (todo:Todos, position:Int) -> Unit) : RecyclerView.ViewHolder(itemView) {

        val txtTask: TextView? = itemView?.findViewById(R.id.txtTask)

        fun checkChangeListener(todo: Todos) {
            itemView.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
                if (itemView.checkBox.isChecked) {

                    Handler().postDelayed({
                        itemCLick(todo)
                    }, 500)

                }
            }
        }

        fun bindTask(todo: Todos) {
            txtTask?.text = todo.task
            itemView.checkBox.isChecked = false
            itemView.setOnClickListener {
                showDialog(todo,adapterPosition)
            }
        }


    }

}