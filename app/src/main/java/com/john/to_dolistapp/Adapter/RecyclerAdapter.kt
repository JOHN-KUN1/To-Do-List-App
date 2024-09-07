package com.john.to_dolistapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.john.to_dolistapp.Model.ToDo
import com.john.to_dolistapp.databinding.TodoDesignBinding
import com.john.to_dolistapp.databinding.TodoItemBinding

class RecyclerAdapter(): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var todos : List<ToDo> = ArrayList()

    class ViewHolder(val itemBinding: TodoDesignBinding) : RecyclerView.ViewHolder(itemBinding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TodoDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBinding.textViewTitle.text = todos[position].title
        holder.itemBinding.textViewDescription.text = todos[position].description
    }

    fun setTodo(todo : List<ToDo>){
        this.todos = todo
        notifyDataSetChanged()
    }

}