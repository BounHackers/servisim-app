package com.bounhackers.wowservice.login


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bounhackers.wowservice.R
import com.bounhackers.wowservice.base.ProgressIndicatorInterface
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(), LoginContract.View {

    private var presenter: LoginContract.Presenter? = null
    private var onScreenChangeRequestedListener: OnScreenChangeRequestedListener? = null
    private var progressIndicatorInterface: ProgressIndicatorInterface? = null


    private fun onClickLogin(view: View?) {
        presenter?.login(login_edittext_username.text.toString(),
            login_edittext_password.text.toString())
    }

    private fun onClickRegister(view: View?) {
        onScreenChangeRequestedListener?.onRegisterClicked()
    }

    override fun showLoginError() {
        login_edittext_username.error = "Wrong username or password"
    }

    override fun hideLoginError() {
        login_edittext_username.error = null
    }

    override fun showLoginProgress() {
        progressIndicatorInterface?.showProgress()
    }

    override fun hideLoginProgress() {
        progressIndicatorInterface?.hideProgress()
    }

    override fun onLoginSuccessful() {
        onScreenChangeRequestedListener?.onLoginSuccessful()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setPresenter(LoginPresenter(this))

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        login_button_login.setOnClickListener { onClickLogin(view) }
        login_button_register.setOnClickListener { onClickRegister(view) }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is OnScreenChangeRequestedListener) {
            onScreenChangeRequestedListener = context
        } else {
            throw RuntimeException("Activity != OnScreenChangeRequestedListener -_-")
        }
        if(context is ProgressIndicatorInterface) {
            progressIndicatorInterface = context
        }
    }

    override fun onResume() {
        super.onResume()
        presenter?.subscribe()
    }

    override fun onPause() {
        super.onPause()
        presenter?.unsubscribe()
    }

    fun setPresenter(presenter: LoginContract.Presenter) {
        this.presenter = presenter
    }

    interface OnScreenChangeRequestedListener {
        fun onLoginSuccessful()
        fun onRegisterClicked()
    }

    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }


}
