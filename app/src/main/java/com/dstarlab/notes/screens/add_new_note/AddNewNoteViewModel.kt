package com.dstarlab.notes.screens.add_new_note

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.dstarlab.notes.model.dto.AppNoteDTO
import com.dstarlab.notes.model.mapper.AppNoteMapper
import com.dstarlab.notes.screens.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddNewNoteViewModel @Inject constructor(application: Application): BaseViewModel(application) {

    fun insert(note: AppNoteDTO) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(
                    AppNoteMapper().mapFromDomainModel(note)
            )
            updateLiveData()
        }
    }

}