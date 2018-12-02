package com.bounhackers.wowservice.register

import com.bounhackers.wowservice.base.BaseContract

class RegisterContract {
    interface View: BaseContract.View {
        fun onRegisterSuccessful()
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun register(name: String, username: String, password: String)
    }
}