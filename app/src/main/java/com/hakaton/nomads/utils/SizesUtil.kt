package com.hakaton.nomads.utils

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.WindowManager
import kotlin.math.ceil
import kotlin.math.sqrt

class SizesUtil {
    fun calculateDpToPx(context: Context, dp: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }

    fun calculatePxToDp(context: Context, px: Int): Int {
        val aZpx = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            px.toFloat(),
            context.resources.displayMetrics
        )

        val scale: Float = context.resources.displayMetrics.density
        val aXpx: Int = (ceil(px * scale)).toInt()

        return aZpx.toInt()
    }

    fun getDisplayWidth(context: Context): Int {
        return getDisplayMetrics(context).widthPixels
    }

    fun getDisplayHeight(context: Context): Int {
        return getDisplayMetrics(context).heightPixels
    }

    fun isTablet(context: Context): Boolean {
        val metrics = getDisplayMetrics(context)
        val yInches = metrics.heightPixels / metrics.ydpi
        val xInches = metrics.widthPixels / metrics.xdpi
        val diagonalInches = sqrt((xInches * xInches + yInches * yInches).toDouble())
        return diagonalInches >= 6.5
    }

    private fun getDisplayMetrics(context: Context): DisplayMetrics {
        val displayMetrics = DisplayMetrics()
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics
    }
}