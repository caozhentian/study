package com.threeti.study.study.app

import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.annotation.GlideExtension
import com.bumptech.glide.annotation.GlideOption
import com.bumptech.glide.annotation.GlideType
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.RequestOptions.decodeTypeOf

@GlideExtension
class CustomerAppExtension private constructor() {

    companion object {
        // Size of mini thumb in pixels.
        private const val MINI_THUMB_SIZE = 100

        private val DECODE_TYPE_GIF = decodeTypeOf(GifDrawable::class.java).lock()
        @JvmStatic
        @GlideOption
        fun miniThumb(options: RequestOptions) {
            options
                    .fitCenter()
                    .override(MINI_THUMB_SIZE)
        }

        @JvmStatic
        @GlideType(GifDrawable::class)
        fun asGif2(requestBuilder: RequestBuilder<GifDrawable>) {
            requestBuilder
                    .transition(DrawableTransitionOptions())
                    .apply(DECODE_TYPE_GIF)
        }
    }
}// utility class