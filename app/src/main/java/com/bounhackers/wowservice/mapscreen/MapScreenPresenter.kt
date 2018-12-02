package com.bounhackers.wowservice.mapscreen

import android.util.Log
import com.bounhackers.wowservice.Constants
import com.bounhackers.wowservice.appservice.AppServiceInterface
import com.bounhackers.wowservice.appservice.schemas.Route
import com.bounhackers.wowservice.data.Model
import com.bounhackers.wowservice.data.stores.LoggedInUserStore
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList

class MapScreenPresenter(_view: MapScreenContract.View): MapScreenContract.Presenter {

    private val subscriptions: CompositeDisposable = CompositeDisposable()
    private val view: MapScreenContract.View = _view
    private val service: AppServiceInterface = AppServiceInterface.create()

    private val loggedInUserStore = LoggedInUserStore.getInstance()

    override fun subscribe() {
        subscriptions.add(Observable.interval(5, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                refreshVehicleLoc()
            },{

            }))

    }

    private fun refreshVehicleLoc() {
        subscriptions.add(service.getVehicleLoc(Constants.CAR_ID, Constants.ACCESS_TOKEN)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.displayVehicleLocation(it)
            }, {
                Log.e("Vehicle loc", "error", it)
            }))
    }

    override fun onClickLate() {
        view.lateReceived()
    }

    override fun onClickWontCome() {
        subscriptions.add(service.getKidList()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                Observable.fromIterable(it)
            }
            .filter {
                it.parent.id == (loggedInUserStore.getLoggedInEntity() as Model.Parent).id
            }
            .map {
                Model.LateKids(it.id, -1)
            }
            .toList()
            .map {
                val str = StringBuilder()
                for (kid in it) {
                    str.append(kid.kid_id)
                        .append(",")
                        .append(kid.late)
                        .append(";")
                }
                service.updateRoute(Route.UpdateRouteRequest(
                    null,
                    null,
                    null,
                    str.toString()
                ))
            }
            .subscribe({
                view.wontComeReceived()
            }, {
                Log.e("Map Screen", "Error", it)
            })
        )


    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MapScreenContract.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}