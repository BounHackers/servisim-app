package com.bounhackers.wowservice.mapscreen

import com.bounhackers.wowservice.appservice.AppServiceInterface
import io.reactivex.disposables.CompositeDisposable

class MapScreenPresenter(_view: MapScreenContract.View): MapScreenContract.Presenter {

    private val subscribers: CompositeDisposable = CompositeDisposable()
    private val view: MapScreenContract.View = _view
    private val service: AppServiceInterface = AppServiceInterface.create()

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        subscribers.clear()
    }

    override fun attach(view: MapScreenContract.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}