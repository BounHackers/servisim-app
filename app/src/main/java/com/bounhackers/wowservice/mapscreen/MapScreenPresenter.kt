package com.bounhackers.wowservice.mapscreen

import android.util.Log
import com.bounhackers.wowservice.Constants
import com.bounhackers.wowservice.appservice.AppServiceInterface
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit

class MapScreenPresenter(_view: MapScreenContract.View): MapScreenContract.Presenter {

    private val subscribers: CompositeDisposable = CompositeDisposable()
    private val view: MapScreenContract.View = _view
    private val service: AppServiceInterface = AppServiceInterface.create()

    override fun subscribe() {
        subscribers.add(Observable.interval(5, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                refreshVehicleLoc()
            },{

            }))

    }

    private fun refreshVehicleLoc() {
        subscribers.add(service.getVehicleLoc(Constants.CAR_ID, Constants.ACCESS_TOKEN)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.displayVehicleLocation(it)
            }, {
                Log.e("Vehicle loc", "error", it)
            }))
    }

    override fun unsubscribe() {
        subscribers.clear()
    }

    override fun attach(view: MapScreenContract.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}