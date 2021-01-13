package com.dstarlab.notes.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dstarlab.notes.di.ViewModelFactory
import com.dstarlab.notes.di.ViewModelKey
import com.dstarlab.notes.screens.add_new_note.AddNewNoteFragment
import com.dstarlab.notes.screens.add_new_note.AddNewNoteViewModel
import com.dstarlab.notes.screens.main.MainViewModel
import com.dstarlab.notes.screens.note.NoteViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(NoteViewModel::class)
    internal abstract fun bindNoteViewModel(viewModel: NoteViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddNewNoteViewModel::class)
    internal abstract fun bindAddNewNoteViewModel(viewModel: AddNewNoteViewModel): ViewModel

}