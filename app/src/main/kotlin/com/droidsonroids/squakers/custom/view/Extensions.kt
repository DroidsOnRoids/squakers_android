package com.droidsonroids.squakers.custom.view

import android.content.res.Resources
import android.util.TypedValue

internal val blurFactor = (0.18f * 4f)

fun Resources.getPixelsFromDp(dp: Float) : Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics).toInt()
}

fun Resources.getBlurScale() : Float {
    return blurFactor / TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1f, displayMetrics)
}

