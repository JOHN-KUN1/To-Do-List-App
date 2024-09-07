package com.john.to_dolistapp.Repository

import androidx.annotation.WorkerThread
import androidx.room.Update
import com.john.to_dolistapp.Model.ToDo
import com.john.to_dolistapp.ROOM.ToDoDao
import kotlinx.coroutines.flow.Flow

class ToDoRepository(private val toDoDao: ToDoDao) {

    val allTodo : Flow<List<ToDo>> = toDoDao.getAllTodo()

    @WorkerThread
    suspend fun insert(toDo: ToDo){
        toDoDao.Insert(toDo)
    }

    @WorkerThread
    suspend fun update(toDo: ToDo){
        toDoDao.Update(toDo)
    }

    @WorkerThread
    suspend fun delete(toDo: ToDo){
        toDoDao.Delete(toDo)
    }

    @WorkerThread
    suspend fun deleteAll(){
        toDoDao.deleteAllTodo()
    }

}