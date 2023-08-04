package com.ortega.lingaprofil.di

import android.content.Context
import androidx.room.Room
import com.ortega.lingaprofil.data.datasource.ProfileDAO
import com.ortega.lingaprofil.data.datasource.ProfileDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideProfileDB(@ApplicationContext context: Context): ProfileDB {
        return Room.databaseBuilder(
            context = context,
            klass = ProfileDB::class.java,
            name = "lingaprofil.db"
        ).build()
    }

    @Provides
    fun provideProfileDAO(profileDB: ProfileDB): ProfileDAO {
        return profileDB.profileDAO()
    }

}