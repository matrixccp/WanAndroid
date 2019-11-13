package com.showmethe.wanandroid.ui.auth.fragment

import android.os.Bundle
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.LinearInterpolator
import com.google.android.material.circularreveal.CircularRevealCompat
import com.google.android.material.circularreveal.CircularRevealWidget
import com.showmethe.wanandroid.ui.auth.vm.AuthViewModel
import com.showmethe.wanandroid.R
import com.showmethe.wanandroid.databinding.FragmentWelcomeBinding
import com.showmethe.wanandroid.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_welcome.*
import showmethe.github.core.base.BaseFragment
import showmethe.github.core.util.extras.onGlobalLayout
import kotlin.math.hypot

/**
 * Author: showMeThe
 * Update Time: 2019/11/13 15:44
 * Package Name:com.showmethe.wanandroid.ui.auth.fragment
 */
class WelcomeFragment : BaseFragment<FragmentWelcomeBinding, AuthViewModel>() {

    override fun initViewModel(): AuthViewModel = createViewModel(AuthViewModel::class.java)

    override fun getViewId(): Int = R.layout.fragment_welcome

    override fun onBundle(bundle: Bundle) {
    }

    override fun observerUI() {
    }

    override fun init(savedInstanceState: Bundle?) {
        binding?.main = this



        initAnim()

    }

    override fun initListener() {





    }


    fun startReg(){
        viewModel.toNext.value = 1
    }


    fun startToMain(){
        context.startActivity<MainActivity>(null)
        context.finishAfterTransition()
    }

    private fun initAnim(){

        val revealDuration = 1100L
        val logoDuration = 500L

        card.onGlobalLayout {
            val centerX = measuredWidth/2f
            val centerY = measuredHeight/2f
            val finalRadius = hypot(
                centerX.coerceAtLeast(measuredWidth - centerX),
                centerY.coerceAtLeast(measuredHeight - centerY)
            )
            val reveal = CircularRevealWidget.RevealInfo(centerX,centerX,0f)
            card.revealInfo = reveal
            val circularReveal = CircularRevealCompat.createCircularReveal(card,centerX,centerY,finalRadius)
            circularReveal.duration = revealDuration
            circularReveal.startDelay = 50
            circularReveal.interpolator = LinearInterpolator()
            circularReveal.start()
        }


        tvTop.animate()
            .scaleY(1.0f)
            .scaleX(1.0f)
            .alpha(1.0f)
            .setInterpolator(AnticipateOvershootInterpolator())
            .translationY(100f)
            .setDuration(logoDuration)
            .setStartDelay(revealDuration + logoDuration)
            .start()

        tvCenter.animate()
            .scaleY(1.0f)
            .scaleX(1.0f)
            .alpha(1.0f)
            .setInterpolator(AnticipateOvershootInterpolator())
            .translationY(100f)
            .setDuration(logoDuration)
            .setStartDelay(revealDuration + logoDuration)
            .start()

        btnReg.animate()
            .scaleY(1.0f)
            .scaleX(1.0f)
            .alpha(1.0f)
            .setInterpolator(AnticipateOvershootInterpolator())
            .translationY(30f)
            .setDuration(logoDuration)
            .setStartDelay(revealDuration + logoDuration*2)
            .start()

        tvLogin.animate()
            .scaleY(1.0f)
            .scaleX(1.0f)
            .alpha(1.0f)
            .setInterpolator(AnticipateOvershootInterpolator())
            .setDuration(logoDuration)
            .setStartDelay(revealDuration + logoDuration*2)
            .start()

    }


}