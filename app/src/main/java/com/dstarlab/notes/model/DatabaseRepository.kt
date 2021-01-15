package com.dstarlab.notes.model

import androidx.lifecycle.LiveData
import com.dstarlab.notes.model.room.entity.AppNote

interface DatabaseRepository {
    val allNotes: List<AppNote>
    suspend fun insert(appNote: AppNote)
    suspend fun delete(appNote: AppNote)
    suspend fun update(appNote: AppNote)
}