package com.bounhackers.wowservice.profileedit

import com.bounhackers.wowservice.appservice.AppServiceInterface
import io.reactivex.disposables.CompositeDisposable

class ProfileEditPresenter(_view: ProfileEditContract.View): ProfileEditContract.Presenter {

    private val subscribers: CompositeDisposable = CompositeDisposable()
    private val view: ProfileEditContract.View = _view
    private val service: AppServiceInterface = AppServiceInterface.create()

    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unsubscribe() {
        subscribers.clear()
    }

    override fun attach(view: ProfileEditContract.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}