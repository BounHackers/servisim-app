package com.bounhackers.wowservice.splash


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bounhackers.wowservice.R
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class SplashFragment : Fragment() {

    private var onSplashTimerEndListener: OnSplashTimerEndListener? = null
    private var timerDisp: Disposable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is OnSplashTimerEndListener) {
            this.onSplashTimerEndListener = context
        } else {
            throw RuntimeException("Dude! Activity'e OnSplashTimerEndListener ekler misin? Tesekkurler...")
        }
    }

    override fun onResume() {
        super.onResume()
        this.timerDisp = Observable.timer(1, TimeUnit.SECONDS)
            .subscribe {
                this.onSplashTimerEndListener?.onSplashTimerEnd()
            }
    }

    override fun onPause() {
        super.onPause()
        this.timerDisp?.dispose()
    }

    interface OnSplashTimerEndListener {
        fun onSplashTimerEnd()
    }

    companion object {
        fun newInstance(): SplashFragment {
            return SplashFragment()
        }
    }

}
