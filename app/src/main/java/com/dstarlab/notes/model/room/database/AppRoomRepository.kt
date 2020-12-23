package com.dstarlab.notes.model.room.database

import androidx.lifecycle.LiveData
import com.dstarlab.notes.model.DatabaseRepository
import com.dstarlab.notes.model.room.dao.AppRoomDao
import com.dstarlab.notes.model.room.entity.AppNote

class AppRoomRepository(private val appRoomDao: AppRoomDao): DatabaseRepository {

    override val allNotes: LiveData<List<AppNote>>
        get() = appRoomDao.getAllNotes()

    override suspend fun insert(appNote: AppNote) {
        appRoomDao.insert(appNote)
    }

    override suspend fun delete(appNote: AppNote) {
        appRoomDao.delete(appNote)
    }

    override suspend fun update(appNote: AppNote) {
        appRoomDao.update(appNote)
    }

}