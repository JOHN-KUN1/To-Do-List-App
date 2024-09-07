package com.john.to_dolistapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.john.to_dolistapp.Model.ToDo
import com.john.to_dolistapp.Repository.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class TodoViewModel(private val repository: ToDoRepository) : ViewModel() {

    val myTodos : LiveData<List<ToDo>> = repository.allTodo.asLiveData()

    fun Insert(toDo: ToDo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(toDo)
    }

    fun Update(toDo: ToDo) = viewModelScope.launch(Dispatchers.IO){
        repository.update(toDo)
    }

    fun Delete(toDo: ToDo) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(toDo)
    }

    fun DeleteAll() = viewModelScope.launch(Dispatchers.IO){
        repository.deleteAll()
    }

}

class ViewModelFactory(private val repository: ToDoRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoViewModel::class.java)){
            return TodoViewModel(repository) as T
        }else{
            throw IllegalArgumentException("unknown View Model")
        }
    }
}