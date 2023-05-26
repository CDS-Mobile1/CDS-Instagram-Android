package com.sopt.instagram.util.extension

import android.content.res.Resources

fun Int.toPx() = this * Resources.getSystem().displayMetrics.density
