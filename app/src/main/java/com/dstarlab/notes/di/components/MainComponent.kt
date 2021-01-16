package com.dstarlab.notes.di.components

import android.app.Application
import com.dstarlab.notes.di.module.MainModelModule
import com.dstarlab.notes.di.module.ViewModelModule
import com.dstarlab.notes.screens.BaseViewModel
import com.dstarlab.notes.screens.add_new_note.AddNewNoteFragment
import com.dstarlab.notes.screens.main.MainFragment
import com.dstarlab.notes.screens.note.NoteFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, MainModelModule::class])
interface MainComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): MainComponent
    }

    fun inject(mainFragment: MainFragment)
    fun inject(noteFragment: NoteFragment)
    fun inject(addNewNoteFragment: AddNewNoteFragment)
    fun inject(baseViewModel: BaseViewModel)
}