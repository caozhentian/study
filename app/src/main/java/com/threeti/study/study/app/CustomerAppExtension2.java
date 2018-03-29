package com.threeti.study.study.app;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.annotation.GlideType;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestOptions;

import static com.bumptech.glide.request.RequestOptions.decodeTypeOf;

/**
 * Created by ztcao on 2018/3/26.
 */
//@GlideExtension
public class CustomerAppExtension2 {
    // Size of mini thumb in pixels.
    private static final int MINI_THUMB_SIZE = 100;

    private CustomerAppExtension2() {
    } // utility class

//    @GlideOption
//    public static void miniThumb(RequestOptions options) {
//        options
//                .fitCenter()
//                .override(MINI_THUMB_SIZE);
//    }
//
//    private static final RequestOptions DECODE_TYPE_GIF = decodeTypeOf(GifDrawable.class).lock();
//
//    @GlideType(GifDrawable.class)
//    public static void asGif2(RequestBuilder<GifDrawable> requestBuilder) {
//        requestBuilder
//                .transition(new DrawableTransitionOptions())
//                .apply(DECODE_TYPE_GIF);
//    }
}
