package com.bounhackers.wowservice.login


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bounhackers.wowservice.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(), LoginContract.View {

    private var presenter: LoginContract.Presenter? = null
    private var onScreenChangeRequestedListener: OnScreenChangeRequestedListener? = null


    private fun onClickLogin(view: View?) {
        presenter?.login(login_edittext_username.text.toString(),
            login_edittext_password.text.toString())
    }

    private fun onClickRegister(view: View?) {
        onScreenChangeRequestedListener?.onRegisterClicked()
    }

    override fun showLoginError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoginError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoginProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoginProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
