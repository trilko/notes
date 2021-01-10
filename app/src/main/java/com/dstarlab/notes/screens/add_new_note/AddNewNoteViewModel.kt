package com.dstarlab.notes.screens.add_new_note

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.dstarlab.notes.model.room.entity.AppNote
import com.dstarlab.notes.screens.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewNoteViewModel(application: Application): BaseViewModel(application) {

    fun insert(note:AppNote) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(note)
            allNotes = repository.allNotes
        }
    }

}