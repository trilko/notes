package com.dstarlab.notes.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.dstarlab.notes.model.DatabaseRepository
import com.dstarlab.notes.model.room.database.AppRoomDatabase
import com.dstarlab.notes.model.room.database.AppRoomRepository
import com.dstarlab.notes.model.room.entity.AppNote

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val mContext = application
    private val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
    private val repository: DatabaseRepository = AppRoomRepository(dao)

    lateinit var allNotes: LiveData<List<AppNote>>

    fun initAllNotes() {
        allNotes = repository.allNotes
    }

}