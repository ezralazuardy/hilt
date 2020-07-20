package com.ezralazuardy.hilt.ui.list.adapter

import com.ezralazuardy.hilt.model.response.Album

interface AlbumListListener {

    fun onItemClick(album: Album)
}