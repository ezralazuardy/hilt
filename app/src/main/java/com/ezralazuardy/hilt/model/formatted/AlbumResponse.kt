package com.ezralazuardy.hilt.model.formatted

import android.os.Parcelable
import com.ezralazuardy.hilt.constant.RetrofitStatus
import com.ezralazuardy.hilt.model.response.Album
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AlbumResponse(
    val status: RetrofitStatus = RetrofitStatus.UNKNOWN,
    val albums: List<Album>? = null
) : Parcelable