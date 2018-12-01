package com.bounhackers.wowservice.customer

import com.bounhackers.wowservice.appservice.AppServiceInterface
import io.reactivex.disposables.CompositeDisposable

class CustomerPresenter(_view: CustomerContract.View): CustomerContract.Presenter {
    private var view: CustomerContract.View = _view
    private val subscriptions: CompositeDisposable = CompositeDisposable()

    private val service: AppServiceInterface = AppServiceInterface.create()

    override fun subscribe() {
        // empty
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: CustomerContract.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}