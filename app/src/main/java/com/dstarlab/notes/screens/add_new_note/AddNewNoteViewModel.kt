package com.dstarlab.notes.screens.add_new_note

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

class AddNewNoteViewModel(application: Application): AndroidViewModel(application) {

    private val mContext = application
    private val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
    private val repository: DatabaseRepository = AppRoomRepository(dao)

    var allNotes: LiveData<List<AppNote>> = repository.allNotes

    fun insert(note:AppNote) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(note)
            allNotes = repository.allNotes
        }
    }

}