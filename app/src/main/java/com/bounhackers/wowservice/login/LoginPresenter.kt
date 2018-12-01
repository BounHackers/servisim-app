package com.bounhackers.wowservice.login

import com.bounhackers.wowservice.appservice.AppServiceInterface
import com.bounhackers.wowservice.appservice.schemas.Login
import io.reactivex.disposables.CompositeDisposable

class LoginPresenter(_view: LoginContract.View): LoginContract.Presenter {

    private val subscribers: CompositeDisposable = CompositeDisposable()
    private val view: LoginContract.View = _view
    private val service: AppServiceInterface = AppServiceInterface.create()

    override fun login(username: String, password: String) {
        view.showLoginProgress()
        view.hideLoginError()
        subscribers.add(service.parentLogin(Login.LoginRequestBody(username, password))
            .subscribe({
                view.onLoginSuccessful()
            }, {
                view.hideLoginProgress(); view.showLoginError()
            }))
    }

    override fun subscribe() {
        // empty
    }

    override fun unsubscribe() {
        subscribers.clear()
    }

    override fun attach(view: LoginContract.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}