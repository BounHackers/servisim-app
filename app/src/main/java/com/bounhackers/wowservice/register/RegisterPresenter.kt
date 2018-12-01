package com.bounhackers.wowservice.register

import com.bounhackers.wowservice.appservice.AppServiceInterface
import io.reactivex.disposables.CompositeDisposable

class RegisterPresenter(_view: RegisterContract.View): RegisterContract.Presenter {

    private val subscribers: CompositeDisposable = CompositeDisposable()
    private val view: RegisterContract.View = _view
    private val service: AppServiceInterface = AppServiceInterface.create()

    override fun subscribe() {
        // empty
    }

    override fun unsubscribe() {
        subscribers.clear()
    }

    override fun attach(view: RegisterContract.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}