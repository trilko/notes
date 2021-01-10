package com.dstarlab.notes.screens.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.dstarlab.notes.model.DatabaseRepository
import com.dstarlab.notes.model.room.database.AppRoomDatabase
import com.dstarlab.notes.model.room.database.AppRoomRepository
import com.dstarlab.notes.model.room.entity.AppNote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application) {

    private val mContext = application
    private val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
    private val repository: DatabaseRepository = AppRoomRepository(dao)

    var allNotes: LiveData<List<AppNote>> = repository.allNotes

    fun delete(note: AppNote) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(note)
            allNotes = repository.allNotes
        }
    }

    fun update(note: AppNote) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(note)
            allNotes = repository.allNotes
        }
    }
}