package com.belajar.scrollchallenge.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class TopicModel(
    @StringRes val tulisan:Int,
    val id:Int,
    @DrawableRes val gambar:Int
)
