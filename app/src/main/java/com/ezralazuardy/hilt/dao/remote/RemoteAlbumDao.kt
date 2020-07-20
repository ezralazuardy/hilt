package com.ezralazuardy.hilt.dao.remote

import com.ezralazuardy.hilt.model.response.Album
import retrofit2.http.GET

interface RemoteAlbumDao {

    @GET("albums/1/photos")
    suspend fun getAlbums() : List<Album>
}