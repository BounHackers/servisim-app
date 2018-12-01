package com.bounhackers.wowservice.customer

import android.view.View
import com.bounhackers.wowservice.appservice.AppServiceInterface
import io.reactivex.disposables.CompositeDisposable

class CustomerPresenter(_view: View): CustomerContract.Presenter {
    private var view: View = _view
    private val subscriptions: CompositeDisposable = CompositeDisposable()

    private val service: AppServiceInterface = AppServiceInterface.create()

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: CustomerContract.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}