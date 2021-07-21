package com.indialone.androidanimationdemo

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.airbnb.lottie.LottieAnimationView
import com.indialone.androidanimationdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var wifiAnimation: AnimationDrawable
    private lateinit var animationView: LottieAnimationView
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        val animation = AnimationUtils.loadAnimation(this, R.anim.circle_explosion_anim).apply {
            duration = 200
            interpolator = AccelerateDecelerateInterpolator()
        }

        mBinding.btnNext.setOnClickListener {
            mBinding.btnNext.isVisible = false
            mBinding.circle.isVisible = true
            mBinding.circle.startAnimation(animation) {
                mBinding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
                mBinding.circle.isVisible = false
                startActivity(Intent(this, DetailActivity::class.java))
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mBinding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        mBinding.btnNext.isVisible = true
        mBinding.circle.isVisible = false
    }

    override fun onStart() {
        super.onStart()
        mBinding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        mBinding.btnNext.isVisible = true
        mBinding.circle.isVisible = false
    }


}
//        val playIcon = findViewById<ImageView>(R.id.iv_play)
//        val ivWifi = findViewById<ImageView>(R.id.iv_wifi)
//        ivWifi.setBackgroundResource(R.drawable.animation)
//        wifiAnimation = ivWifi.background as AnimationDrawable
//
//
//        playIcon.setOnClickListener {
//            val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
//            playIcon.startAnimation(animation)
//
//            Handler(Looper.getMainLooper()).postDelayed({
//                playIcon.setImageDrawable(
//                    AppCompatResources.getDrawable(
//                        this,
//                        R.drawable.icon_pause
//                    )
//                )
//            }, 200)
//
//            Handler(Looper.getMainLooper()).postDelayed({
//                playIcon.clearAnimation()
//            }, 400)
//        }


//    override fun onWindowFocusChanged(hasFocus: Boolean) {
//        super.onWindowFocusChanged(hasFocus)
//        wifiAnimation.start()
//    }

/*
    for lottie animation

    mBinding.btnNext.setOnClickListener {
            animationView.visibility = View.VISIBLE
            mBinding.btnNext.visibility = View.GONE
            animationView.playAnimation()
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, DetailActivity::class.java))
                finish()
            }, 2000)

        }
 */