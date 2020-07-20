package com.ezralazuardy.hilt.repository

import com.ezralazuardy.hilt.dao.remote.RemoteAlbumDao
import com.ezralazuardy.hilt.model.response.Album
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import javax.inject.Inject

@Module
@InstallIn(ActivityRetainedComponent::class)
class AlbumRepository @Inject constructor(
    private val albumDao: RemoteAlbumDao
) {

    suspend fun getAlbums(): List<Album> = albumDao.getAlbums()
}