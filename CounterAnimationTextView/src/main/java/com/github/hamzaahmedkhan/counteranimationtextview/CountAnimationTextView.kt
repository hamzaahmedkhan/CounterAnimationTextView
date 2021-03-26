package com.github.hamzaahmedkhan.counteranimationtextview

import android.animation.Animator
import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import java.text.DecimalFormat

class CountAnimationTextView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextView(context, attrs, defStyleAttr) {
    private var isAnimating = false
    private var mCountAnimator: ValueAnimator? = null
    private var mCountAnimationListener: CountAnimationListener? = null
    private var mDecimalFormat: DecimalFormat? = null
    private fun setUpAnimator() {
        mCountAnimator = ValueAnimator()
        mCountAnimator!!.addUpdateListener { animation ->
            val value: String
            value = if (mDecimalFormat == null) {
                animation.animatedValue.toString()
            } else {
                mDecimalFormat!!.format(animation.animatedValue)
            }
            super@CountAnimationTextView.setText(value)
        }
        mCountAnimator!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                isAnimating = true
                if (mCountAnimationListener == null) return
                mCountAnimationListener!!.onAnimationStart(mCountAnimator!!.animatedValue)
            }

            override fun onAnimationEnd(animation: Animator) {
                isAnimating = false
                if (mCountAnimationListener == null) return
                mCountAnimationListener!!.onAnimationEnd(mCountAnimator!!.animatedValue)
            }

            override fun onAnimationCancel(animation: Animator) {
                // do nothing
            }

            override fun onAnimationRepeat(animation: Animator) {
                // do nothing
            }
        })
        mCountAnimator!!.duration = DEFAULT_DURATION
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        if (mCountAnimator != null) {
            mCountAnimator!!.cancel()
        }
    }

    fun countAnimation(fromValue: Int, toValue: Int) {
        if (isAnimating) return
        mCountAnimator!!.setIntValues(fromValue, toValue)
        mCountAnimator!!.start()
    }

    fun setAnimationDuration(duration: Long): CountAnimationTextView {
        mCountAnimator!!.duration = duration
        return this
    }

    fun setInterpolator(value: TimeInterpolator): CountAnimationTextView {
        mCountAnimator!!.interpolator = value
        return this
    }

    // interface progress animationListener
    interface CountAnimationListener {
        fun onAnimationStart(animatedValue: Any?)
        fun onAnimationEnd(animatedValue: Any?)
    }

    fun setDecimalFormat(mDecimalFormat: DecimalFormat?): CountAnimationTextView {
        this.mDecimalFormat = mDecimalFormat
        return this
    }

    fun clearDecimalFormat() {
        mDecimalFormat = null
    }

    fun setCountAnimationListener(mCountAnimationListener: CountAnimationListener?): CountAnimationTextView {
        this.mCountAnimationListener = mCountAnimationListener
        return this
    }

    companion object {
        private const val DEFAULT_DURATION: Long = 1000
    }

    init {
        setUpAnimator()
    }
}