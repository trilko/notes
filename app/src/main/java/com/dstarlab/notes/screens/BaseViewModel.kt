package com.dstarlab.notes.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.dstarlab.notes.model.DatabaseRepository
import com.dstarlab.notes.model.room.database.AppRoomDatabase
import com.dstarlab.notes.model.room.database.AppRoomRepository
import com.dstarlab.notes.model.room.entity.AppNote

open class BaseViewModel(application: Application): AndroidViewModel(application) {

    private val mContext = application
    private val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
    protected val repository: DatabaseRepository = AppRoomRepository(dao)

    var allNotes: LiveData<List<AppNote>> = repository.allNotes

}