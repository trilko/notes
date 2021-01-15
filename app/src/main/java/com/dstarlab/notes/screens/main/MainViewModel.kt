package com.dstarlab.notes.screens.main

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.dstarlab.notes.di.components.DaggerMainComponent
import com.dstarlab.notes.model.mapper.AppNoteMapper
import com.dstarlab.notes.model.room.entity.AppNote
import com.dstarlab.notes.screens.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(application: Application): BaseViewModel(application) {

    override fun updateLiveData() {
        viewModelScope.launch(Dispatchers.IO) {
            allNotes.postValue(
                    AppNoteMapper().toDomainList(repository.allNotes)
            )
        }
    }
}