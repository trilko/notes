package com.dstarlab.notes.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.dstarlab.notes.di.components.DaggerMainComponent
import com.dstarlab.notes.model.DatabaseRepository
import com.dstarlab.notes.model.dto.AppNoteDTO
import com.dstarlab.notes.model.mapper.AppNoteMapper
import javax.inject.Inject

open class BaseViewModel @Inject constructor(application: Application): AndroidViewModel(application) {

    @Inject
    lateinit var repository: DatabaseRepository

    val allNotes = MutableLiveData<List<AppNoteDTO>>()

    init {
        DaggerMainComponent.builder().application(application).build().inject(this)
    }

    open fun updateLiveData() {
        allNotes.postValue(
                AppNoteMapper().toDomainList(repository.allNotes)
        )
    }

}