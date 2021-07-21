package com.indialone.androidanimationdemo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    var image: Int = 0,
    var name: String = "",
    var about: String = ""
) : Parcelable
