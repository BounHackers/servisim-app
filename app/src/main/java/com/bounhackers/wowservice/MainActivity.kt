package com.bounhackers.wowservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bounhackers.wowservice.base.ProgressIndicatorInterface
import com.bounhackers.wowservice.customer.CustomerFragment
import com.bounhackers.wowservice.data.Model
import com.bounhackers.wowservice.login.LoginFragment
import com.bounhackers.wowservice.mapscreen.MapScreenFragment
import com.bounhackers.wowservice.register.RegisterFragment
import com.bounhackers.wowservice.splash.SplashFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SplashFragment.OnSplashTimerEndListener,
    LoginFragment.OnScreenChangeRequestedListener,
    ProgressIndicatorInterface,
    RegisterFragment.OnChangeScreenRequestListener,
    CustomerFragment.OnClickChildListener {

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

    override fun onLoginSuccessful() {
        changeScreen(AppScreenState.MAP)
    }

    override fun onRegisterClicked() {
        changeScreen(AppScreenState.REGISTER)
    }

    override fun onSplashTimerEnd() {
        changeScreen(AppScreenState.LOGIN)
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
                supportFragmentManager.beginTransaction()
                    .replace(R.id.root_layout, RegisterFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }
            AppScreenState.CUSTOMER -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.root_layout, CustomerFragment.newInstance())
                    .commit()
            }
            AppScreenState.MAP -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.root_layout, MapScreenFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
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


    override fun onClickChild(kid: Model.Kid) {

    }



    override fun onRegisterBackPressed() {
        changeScreen(AppScreenState.LOGIN)
    }

    override fun onRegisterSuccessful() {
        changeScreen(AppScreenState.LOGIN)
    }




    override fun showProgress() {
        main_progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        main_progress_bar.visibility = View.GONE
    }

}
