package com.bounhackers.wowservice.login

import com.bounhackers.wowservice.appservice.AppServiceInterface
import io.reactivex.disposables.CompositeDisposable

class LoginPresenter(_view: LoginContract.View): LoginContract.Presenter {

    private val subscribers: CompositeDisposable = CompositeDisposable()
    private val view: LoginContract.View = _view
    private val service: AppServiceInterface = AppServiceInterface.create()

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        subscribers.clear()
    }

    override fun attach(view: LoginContract.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}