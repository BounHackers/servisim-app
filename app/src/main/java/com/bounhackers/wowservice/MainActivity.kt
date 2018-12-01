package com.bounhackers.wowservice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bounhackers.wowservice.login.LoginFragment
import com.bounhackers.wowservice.splash.SplashFragment

class MainActivity : AppCompatActivity(), SplashFragment.OnSplashTimerEndListener,
    LoginFragment.OnScreenChangeRequestedListener {
    override fun onLoginSuccessful() {
        changeScreen(AppScreenState.CUSTOMER)
    }

    override fun onRegisterClicked() {
        changeScreen(AppScreenState.REGISTER)
    }

    override fun onSplashTimerEnd() {
        changeScreen(AppScreenState.LOGIN)
    }

    enum class AppScreenState {
        SPLASH,
        LOGIN,
        REGISTER,
        CUSTOMER,
        MAP
    }

    private var screenState: AppScreenState = AppScreenState.SPLASH

    fun changeScreen(state: AppScreenState) {
        if(this.screenState == state) {
            return
        } else {
            switchFragment(state)
            this.screenState = state
        }
    }

    private fun switchFragment(state: AppScreenState) {
        when(state) {
            AppScreenState.SPLASH -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.root_layout, SplashFragment.newInstance())
                    .commit()
            }
            AppScreenState.LOGIN -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.root_layout, LoginFragment.newInstance())
                    .commit()
            }
            AppScreenState.REGISTER -> {

            }
            AppScreenState.CUSTOMER -> {

            }
            AppScreenState.MAP -> {

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.root_layout, SplashFragment.newInstance())
            .commit()
    }

}
