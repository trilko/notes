package com.dstarlab.notes.model.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dstarlab.notes.model.room.entity.AppNote

@Dao
interface AppRoomDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(appNote: AppNote)

    @Delete
    fun delete(appNote: AppNote)

    @Query("Select * from notes_tables")
    fun getAllNotes(): LiveData<List<AppNote>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(appNote: AppNote)
}