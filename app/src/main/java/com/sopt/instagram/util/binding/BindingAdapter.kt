package com.sopt.instagram.util.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.sopt.instagram.util.extension.toPx

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("setCircleImage")
    fun ImageView.setCircleImage(img: String?) {
        load(img) {
            transformations(CircleCropTransformation())
        }
    }

    @JvmStatic
    @BindingAdapter("setRoundedCornersImage")
    fun ImageView.setRoundedCornersImage(img: String?) {
        load(img) {
            transformations(RoundedCornersTransformation(6.toPx()))
        }
    }
}
