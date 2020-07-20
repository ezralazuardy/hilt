package com.ezralazuardy.hilt.database.remote

import com.ezralazuardy.hilt.dao.remote.RemoteAlbumDao
import com.ezralazuardy.hilt.utils.Retrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RemoteDatabase {

    @Provides
    @Singleton
    fun provideAlbumDAO(): RemoteAlbumDao = Retrofit.getClient().create(RemoteAlbumDao::class.java)
}