package com.github.hamzaahmedkhan.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    var durationInMs = 3000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartAnimation.setOnClickListener {
            forwardCount.setAnimationDuration(durationInMs).countAnimation(0, 9999)
            reverseCount.setAnimationDuration(durationInMs).countAnimation(9999, 1)
            moneyPositive.setAnimationDuration(durationInMs).setDecimalFormat(DecimalFormat("###,###,###")).countAnimation(0, 999999999)
            moneyNegative.setAnimationDuration(durationInMs).setDecimalFormat(DecimalFormat("###,###,###")).countAnimation(999999999, 9999)
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