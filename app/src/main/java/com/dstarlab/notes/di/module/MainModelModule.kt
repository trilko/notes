package com.dstarlab.notes.di.module

import android.app.Application
import com.dstarlab.notes.model.DatabaseRepository
import com.dstarlab.notes.model.room.dao.AppRoomDao
import com.dstarlab.notes.model.room.database.AppRoomDatabase
import com.dstarlab.notes.model.room.database.AppRoomRepository
import dagger.Module
import dagger.Provides

@Module(includes = [ViewModelModule::class])
class MainModelModule {

    @Provides
    fun bindDaoProvider(mContext: Application): AppRoomDao {
        return AppRoomDatabase.getInstance(mContext).getAppRoomDao()
    }

    @Provides
    fun bindRepositoryProvider(dao: AppRoomDao): DatabaseRepository {
        return AppRoomRepository(dao)
    }
}