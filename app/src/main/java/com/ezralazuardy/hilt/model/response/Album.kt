package com.ezralazuardy.hilt.model.response

import android.os.Parcelable
import android.webkit.WebSettings
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.ezralazuardy.hilt.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Album(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
) : Parcelable {

    companion object {

        @JvmStatic
        @BindingAdapter("image")
        fun loadImage(imageView: ImageView, url: String) {
            Glide.with(imageView.context)
                .load(GlideUrl(url, LazyHeaders.Builder().addHeader("User-Agent", WebSettings.getDefaultUserAgent(imageView.context)).build()))
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .transition(DrawableTransitionOptions.withCrossFade())
                .fitCenter()
                .placeholder(R.color.colorShimmer)
                .error(R.color.colorShimmer)
                .into(imageView)
        }
    }
}