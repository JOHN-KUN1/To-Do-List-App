package com.john.to_dolistapp.Application

import android.app.Application
import com.john.to_dolistapp.ROOM.ToDoDatabase
import com.john.to_dolistapp.Repository.ToDoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ToDoApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { ToDoDatabase.getDatabase(this,applicationScope) }
    val repository by lazy { ToDoRepository(database.getDao())}

}