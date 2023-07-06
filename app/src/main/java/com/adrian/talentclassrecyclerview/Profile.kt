package com.adrian.talentclassrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Profile(
    val name: String,
    val email: String,
    val major: String,
    val semester: String,
    val photo: Int
): Parcelable
