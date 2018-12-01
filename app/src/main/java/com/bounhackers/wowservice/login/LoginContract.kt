package com.bounhackers.wowservice.login

import com.bounhackers.wowservice.base.BaseContract

class LoginContract {
    interface View: BaseContract.View {
        fun showLoginError()
        fun hideLoginError()

        fun showLoginProgress()
        fun hideLoginProgress()

        fun onLoginSuccessful()
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun login(username: String, password: String)
    }
}