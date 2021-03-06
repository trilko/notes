package com.dstarlab.notes.model.room.database

import com.dstarlab.notes.model.DatabaseRepository
import com.dstarlab.notes.model.room.dao.AppRoomDao
import com.dstarlab.notes.model.room.entity.AppNote
import javax.inject.Inject

class AppRoomRepository @Inject constructor(private val appRoomDao: AppRoomDao): DatabaseRepository {

    override val allNotes: List<AppNote>
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