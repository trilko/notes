package com.dstarlab.notes.screens.note

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.dstarlab.notes.model.room.entity.AppNote
import com.dstarlab.notes.screens.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): BaseViewModel(application) {

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