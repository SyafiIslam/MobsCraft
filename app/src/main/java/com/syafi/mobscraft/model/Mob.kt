package com.syafi.mobscraft.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize


@Parcelize
data class Mob(
    val name: String,
    val behavior: String,
    val hp: String,
    val description: String,
    @DrawableRes
    val photo: Int
): Parcelable
