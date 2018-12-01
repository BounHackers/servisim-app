package com.bounhackers.wowservice.login


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bounhackers.wowservice.R

class LoginFragment : Fragment(), LoginContract.View {

    private var presenter: LoginPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setPresenter(LoginPresenter(this))
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    fun setPresenter(presenter: LoginPresenter) {
        this.presenter = presenter
    }


}
