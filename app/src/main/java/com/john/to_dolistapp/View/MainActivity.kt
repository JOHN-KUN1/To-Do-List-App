package com.john.to_dolistapp.View

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.john.to_dolistapp.Adapter.RecyclerAdapter
import com.john.to_dolistapp.Application.ToDoApplication
import com.john.to_dolistapp.R
import com.john.to_dolistapp.ViewModel.TodoViewModel
import com.john.to_dolistapp.ViewModel.ViewModelFactory
import com.john.to_dolistapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var todoViewModel: TodoViewModel
    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val todoFactory = ViewModelFactory((application as ToDoApplication).repository)
        todoViewModel = ViewModelProvider(this,todoFactory).get(TodoViewModel::class.java)
        val adapter = RecyclerAdapter()
        mainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        mainBinding.recyclerView.adapter = adapter
        todoViewModel.myTodos.observe(this, Observer {todo ->
            //update the ui
            adapter.setTodo(todo)
        })

    }
}