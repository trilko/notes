package com.dstarlab.notes.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.dstarlab.notes.di.components.DaggerMainComponent
import com.dstarlab.notes.model.DatabaseRepository
import com.dstarlab.notes.model.room.database.AppRoomDatabase
import com.dstarlab.notes.model.room.database.AppRoomRepository
import com.dstarlab.notes.model.room.entity.AppNote
import javax.inject.Inject

open class BaseViewModel @Inject constructor(application: Application): AndroidViewModel(application) {

//    private val mContext = application
//    private val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
//    protected val repository: DatabaseRepository = AppRoomRepository(dao)
    @Inject
    lateinit var repository: DatabaseRepository

    init {
        DaggerMainComponent.builder().application(application).build().inject(this)
    }

    var allNotes: LiveData<List<AppNote>> = repository.allNotes

}