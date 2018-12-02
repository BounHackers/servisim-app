package com.bounhackers.wowservice.mapscreen

import com.bounhackers.wowservice.appservice.schemas.Vehicle
import com.bounhackers.wowservice.base.BaseContract

class MapScreenContract {
    interface View: BaseContract.View {
        fun displayVehicleLocation(location: Vehicle.Location)

        fun wontComeReceived()
        fun lateReceived()
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun onClickLate()
        fun onClickWontCome()
    }
}