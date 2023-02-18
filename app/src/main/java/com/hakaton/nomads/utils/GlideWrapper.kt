package com.hakaton.nomads.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.signature.ObjectKey

class GlideWrapper(context: Context) {
    private val glideApp = Glide.with(context)


    fun loadImage(url: String?, imageView: ImageView) {
        glideApp
            .load(url)
            .signature(ObjectKey(url ?: "rand"))
            .transition(DrawableTransitionOptions.withCrossFade())
            .fitCenter()
            .into(imageView)
    }

    fun loadImageNoCash(imageView: ImageView, url: String?) {
        glideApp
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .fitCenter()
            .into(imageView)
    }
}