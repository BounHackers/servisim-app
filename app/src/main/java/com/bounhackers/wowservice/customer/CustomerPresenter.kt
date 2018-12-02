package com.bounhackers.wowservice.customer

import android.util.Log
import com.bounhackers.wowservice.appservice.AppServiceInterface
import com.bounhackers.wowservice.data.Model
import com.bounhackers.wowservice.data.stores.LoggedInUserStore
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CustomerPresenter(_view: CustomerContract.View): CustomerContract.Presenter {

    private val view: CustomerContract.View = _view
    private val subscriptions: CompositeDisposable = CompositeDisposable()

    private val service: AppServiceInterface = AppServiceInterface.create()
    private val loggedInUserStore: LoggedInUserStore = LoggedInUserStore.getInstance()

    override fun subscribe() {
        if(loggedInUserStore.getLoggedInEntity() is Model.Parent) {
            subscriptions.add(service.getKidList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap {
                    Observable.fromIterable(it)
                }
                .filter {
                    it.parent.id == (loggedInUserStore.getLoggedInEntity() as Model.Parent).id
                }
                .toList()
                .subscribe({
                    view.fillKids(it)
                }, {
                    Log.e("Customer Presenter", "Error", it)
                }))
            view.fillParentInfo(loggedInUserStore.getLoggedInEntity() as Model.Parent)
        }

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: CustomerContract.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addChild(kid: Model.Kid) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}