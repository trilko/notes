package com.dstarlab.notes.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.dstarlab.notes.model.room.database.AppRoomDatabase
import com.dstarlab.notes.model.room.database.AppRoomRepository
import com.dstarlab.notes.utilits.REPOSITORY

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val mContext = application

    fun initDatabase(onSuccess: () -> Unit) {
        val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
        REPOSITORY = AppRoomRepository(dao)
        onSuccess()
    }
}