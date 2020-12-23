package com.dstarlab.notes.screens.add_new_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dstarlab.notes.model.room.entity.AppNote
import com.dstarlab.notes.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewNoteViewModel(application: Application): AndroidViewModel(application) {
    fun insert(note:AppNote, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insert(note)
            onSuccess()
        }
    }
}