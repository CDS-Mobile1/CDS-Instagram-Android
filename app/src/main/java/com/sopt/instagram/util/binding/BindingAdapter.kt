package com.sopt.instagram.util.binding

import android.view.View
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.sopt.instagram.R
import com.sopt.instagram.domain.entity.type.StoryState
import com.sopt.instagram.domain.entity.type.StoryState.DEFAULT
import com.sopt.instagram.domain.entity.type.StoryState.NONE
import com.sopt.instagram.domain.entity.type.StoryState.READ
import com.sopt.instagram.domain.entity.type.StoryState.SPECIAL
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

    @JvmStatic
    @BindingAdapter("setStoryProfileStroke")
    fun View.setStoryProfileStroke(state: StoryState) {
        background = when (state) {
            DEFAULT -> AppCompatResources.getDrawable(context, R.drawable.bg_story_profile_default)
            SPECIAL -> AppCompatResources.getDrawable(context, R.drawable.bg_story_profile_special)
            READ -> AppCompatResources.getDrawable(context, R.drawable.bg_story_profile_read)
            NONE -> return
        }
    }
}
