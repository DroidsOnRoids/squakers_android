package com.droidsonroids.squakers.custom.view

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.widget.FrameLayout
import com.droidsonroids.squakers.R
import kotlinx.android.synthetic.main.custom_fab.view.*
import pl.droidsonroids.hematoonkologia.widget.blur.BlurBuilder

class GradientFab(context: Context?, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    companion object {
        var gradientShadowBitmap: Bitmap? = null
    }

    private var badgeHeight = 0
    private var badgeWidth = 0
    private var shadowBlurScale = 0f
    private var shadowBlurRadius = 10.0f
    private var shadowPaddingTop = 0
    private var shadowPaddingBottom = 0
    private var shadowPaddingLeft = 0
    private var shadowPaddingRight = 0
    private val shadowPadding = 14.0f

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_fab, this, true)
        calculateDimensions()
    }

    private fun calculateDimensions() {
        shadowBlurScale = resources.getBlurScale()
        shadowPaddingTop = resources.getPixelsFromDp(shadowPadding)
        shadowPaddingBottom = resources.getPixelsFromDp(shadowPadding)
        shadowPaddingLeft = resources.getPixelsFromDp(shadowPadding)
        shadowPaddingRight = resources.getPixelsFromDp(shadowPadding)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        badgeWidth = resources.getPixelsFromDp(80f)
        badgeHeight = resources.getPixelsFromDp(80f)
        if (!isInEditMode) {
            createGradientShadowBitmap()
            drawGradientShadow()
            badgeBackground.setOnTouchListener { v, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> animateShadowScaleUp()
                    MotionEvent.ACTION_CANCEL, MotionEvent.ACTION_UP -> animateShadowScaleDown()
                }
                true
            }
        }
    }

    private fun drawGradientShadow() {
        badgeGradientShadowImageView.setImageBitmap(gradientShadowBitmap)
    }

    private fun createGradientShadowBitmap() {
        if (gradientShadowBitmap == null) {
            val bitmap = Bitmap.createBitmap(badgeWidth + shadowPaddingRight, badgeHeight + shadowPaddingBottom, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            val gradientDrawable = ContextCompat.getDrawable(context, R.drawable.fab_background_ripple)
            gradientDrawable.setBounds(shadowPaddingLeft, shadowPaddingTop, badgeWidth, badgeHeight)
            gradientDrawable.draw(canvas)
            gradientShadowBitmap = BlurBuilder.blur(context, bitmap, shadowBlurScale, shadowBlurRadius)
        }
    }

    private fun animateShadowScaleUp() {
        val set = AnimatorSet()
        set.play(ObjectAnimator.ofFloat(badgeGradientShadowImageView, "scaleX", 1.08f).setDuration(100))
                .with(ObjectAnimator.ofFloat(badgeGradientShadowImageView, "scaleY", 1.08f)
                        .setDuration(100))
        set.start()
    }

    private fun animateShadowScaleDown() {
        val set = AnimatorSet()
        set.play(ObjectAnimator.ofFloat(badgeGradientShadowImageView, "scaleX", 1f).setDuration(100))
                .with(ObjectAnimator.ofFloat(badgeGradientShadowImageView, "scaleY", 1f)
                        .setDuration(100))
        set.start()
    }
}