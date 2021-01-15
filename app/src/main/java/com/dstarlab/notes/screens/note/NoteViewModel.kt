package com.dstarlab.notes.screens.note

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dstarlab.notes.di.components.DaggerMainComponent
import com.dstarlab.notes.model.dto.AppNoteDTO
import com.dstarlab.notes.model.mapper.AppNoteMapper
import com.dstarlab.notes.model.room.entity.AppNote
import com.dstarlab.notes.screens.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteViewModel @Inject constructor(application: Application): BaseViewModel(application) {

    fun delete(note: AppNoteDTO) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(
                    AppNoteMapper().mapFromDomainModel(note)
            )
            updateLiveData()
        }
    }

    fun update(note: AppNoteDTO) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(
                    AppNoteMapper().mapFromDomainModel(note)
            )
            updateLiveData()
        }
    }

}