package com.ezralazuardy.hilt.ui.list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ezralazuardy.hilt.constant.RetrofitStatus
import com.ezralazuardy.hilt.model.formatted.AlbumResponse
import com.ezralazuardy.hilt.repository.AlbumRepository
import com.ezralazuardy.hilt.utils.Retrofit.printRetrofitError
import kotlinx.coroutines.launch

class ListViewModel @ViewModelInject constructor(
    private val albumRepository: AlbumRepository
) : ViewModel() {

    private val _albums = MutableLiveData<AlbumResponse>()
    val albums: LiveData<AlbumResponse> = _albums

    init {
        getAlbums()
    }

    fun getAlbums() = viewModelScope.launch {
        try {
            _albums.postValue(AlbumResponse(RetrofitStatus.SUCCESS, albumRepository.getAlbums()))
        } catch (e: Exception) {
            _albums.postValue(AlbumResponse(RetrofitStatus.FAILURE))
            e.printRetrofitError()
        }
    }
}