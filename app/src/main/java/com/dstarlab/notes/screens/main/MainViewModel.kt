package com.dstarlab.notes.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.dstarlab.notes.model.room.database.AppRoomDatabase
import com.dstarlab.notes.model.room.database.AppRoomRepository
import com.dstarlab.notes.model.room.entity.AppNote
import com.dstarlab.notes.utilits.REPOSITORY

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val mContext = application
    lateinit var allNotes: LiveData<List<AppNote>>

    fun initDatabase(onSuccess: () -> Unit) {
        val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
        REPOSITORY = AppRoomRepository(dao)
        onSuccess()
    }

    fun initAllNotes() {
        allNotes = REPOSITORY.allNotes
    }
}