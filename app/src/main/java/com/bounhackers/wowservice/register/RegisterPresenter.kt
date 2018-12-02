package com.bounhackers.wowservice.register

import android.util.Log
import com.bounhackers.wowservice.appservice.AppServiceInterface
import com.bounhackers.wowservice.appservice.schemas.Parent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

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

    override fun register(name: String, username: String, password: String) {
        subscribers.add(service.registerParent(Parent.RegisterParentRequest(name, null, username, password))
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.onRegisterSuccessful()
            }, {
                Log.e("Register", "Error", it)
            }))
    }

}