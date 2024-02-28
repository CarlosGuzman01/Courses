package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CourseTopic(
    @StringRes val courseName: Int,
    val courseNumber: Int,
    @DrawableRes val courseImage: Int
)
