package com.github.hamzaahmedkhan.sampleapp

import android.os.Bundle
import android.util.Log
import android.view.animation.*
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    var durationInMs = 2000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartAnimation.setOnClickListener {
            when (rgInterpolator.checkedRadioButtonId) {
                R.id.rbNone -> {
                    Log.e("TEST", "R.id.rbNone")
                    forwardCount.setAnimationDuration(durationInMs).countAnimation(1, 999999)
                    reverseCount.setAnimationDuration(durationInMs).countAnimation(999999, 1)
                    moneyPositive.setAnimationDuration(durationInMs)
                        .setDecimalFormat(DecimalFormat("###,###,###")).countAnimation(0, 9999999)
                    moneyNegative.setAnimationDuration(durationInMs)
                        .setDecimalFormat(DecimalFormat("###,###,###")).countAnimation(9999999, 0)
                }
                R.id.rbOvershoot -> {
                    Log.e("TEST", "R.id.rbAccelerate")
                    val overshootInterpolator = OvershootInterpolator(0.3f)
                    forwardCount.setAnimationDuration(durationInMs)
                        .setInterpolator(overshootInterpolator).countAnimation(1, 999999)
                    reverseCount.setAnimationDuration(durationInMs)
                        .setInterpolator(overshootInterpolator).countAnimation(999999, 1)
                    moneyPositive.setAnimationDuration(durationInMs)
                        .setInterpolator(overshootInterpolator)
                        .setDecimalFormat(DecimalFormat("###,###,###")).countAnimation(99, 9999999)
                    moneyNegative.setAnimationDuration(durationInMs)
                        .setInterpolator(overshootInterpolator)
                        .setDecimalFormat(DecimalFormat("###,###,###")).countAnimation(9999999, 99)
                }

                R.id.rbFastOutSlowIn -> {
                    Log.e("TEST", "R.id.rbAccelerate")
                    val fastOutSlowInInterpolator = FastOutSlowInInterpolator()
                    forwardCount.setAnimationDuration(durationInMs)
                        .setInterpolator(fastOutSlowInInterpolator).countAnimation(1, 999999)
                    reverseCount.setAnimationDuration(durationInMs)
                        .setInterpolator(fastOutSlowInInterpolator).countAnimation(999999, 1)
                    moneyPositive.setAnimationDuration(durationInMs)
                        .setInterpolator(fastOutSlowInInterpolator)
                        .setDecimalFormat(DecimalFormat("###,###,###")).countAnimation(99, 9999999)
                    moneyNegative.setAnimationDuration(durationInMs)
                        .setInterpolator(fastOutSlowInInterpolator)
                        .setDecimalFormat(DecimalFormat("###,###,###")).countAnimation(9999999, 99)
                }

                R.id.rbAccelerate -> {
                    Log.e("TEST", "R.id.rbAccelerate")
                    val accelerateInterpolator = AccelerateInterpolator(2.0f)
                    forwardCount.setAnimationDuration(durationInMs)
                        .setInterpolator(accelerateInterpolator).countAnimation(1, 999999)
                    reverseCount.setAnimationDuration(durationInMs)
                        .setInterpolator(accelerateInterpolator).countAnimation(999999, 1)
                    moneyPositive.setAnimationDuration(durationInMs)
                        .setInterpolator(accelerateInterpolator)
                        .setDecimalFormat(DecimalFormat("###,###,###")).countAnimation(99, 9999999)
                    moneyNegative.setAnimationDuration(durationInMs)
                        .setInterpolator(accelerateInterpolator)
                        .setDecimalFormat(DecimalFormat("###,###,###")).countAnimation(9999999, 99)
                }

                R.id.rbDecelerate -> {
                    Log.e("TEST", "R.id.rbDecelerate")

                    val value = DecelerateInterpolator(2.0f)
                    forwardCount.setAnimationDuration(durationInMs)
                        .setInterpolator(value).countAnimation(1, 999999)
                    reverseCount.setAnimationDuration(durationInMs)
                        .setInterpolator(value).countAnimation(999999, 1)
                    moneyPositive.setAnimationDuration(durationInMs)
                        .setInterpolator(value)
                        .setDecimalFormat(DecimalFormat("###,###,###")).countAnimation(99, 9999999)
                    moneyNegative.setAnimationDuration(durationInMs)
                        .setInterpolator(value)
                        .setDecimalFormat(DecimalFormat("###,###,###")).countAnimation(9999999, 99)
                }

                R.id.rbAccelerateDecelerate -> {
                    Log.e("TEST", "R.id.rbAccelerateDecelerate")

                    val value = AccelerateDecelerateInterpolator()
                    forwardCount.setAnimationDuration(durationInMs)
                        .setInterpolator(value).countAnimation(1, 999999)
                    reverseCount.setAnimationDuration(durationInMs)
                        .setInterpolator(value).countAnimation(999999, 1)
                    moneyPositive.setAnimationDuration(durationInMs)
                        .setInterpolator(value)
                        .setDecimalFormat(DecimalFormat("###,###,###")).countAnimation(99, 9999999)
                    moneyNegative.setAnimationDuration(durationInMs)
                        .setInterpolator(value)
                        .setDecimalFormat(DecimalFormat("###,###,###")).countAnimation(9999999, 99)
                }
            }
        }

        seekbarAnimationDuration.setOnSeekBarChangeListener(this)
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        durationInMs = progress.toLong()
        txtAnimationDuration.text = durationInMs.toString()
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}