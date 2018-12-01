package com.bounhackers.wowservice.routelist

import com.bounhackers.wowservice.appservice.AppServiceInterface
import io.reactivex.disposables.CompositeDisposable

class RouteListPresenter(_view: RouteListContract.View): RouteListContract.Presenter {

    private val subscribers: CompositeDisposable = CompositeDisposable()
    private val service: AppServiceInterface = AppServiceInterface.create()
    private val view: RouteListContract.View = _view

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        subscribers.clear()
    }

    override fun attach(view: RouteListContract.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}