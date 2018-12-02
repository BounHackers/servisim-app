package com.bounhackers.wowservice.customer

import com.bounhackers.wowservice.base.BaseContract
import com.bounhackers.wowservice.data.Model

class CustomerContract {
    interface View: BaseContract.View {
        fun fillParentInfo(parent: Model.Parent)
        fun fillKids(kids: List<Model.Kid>)
        fun addChildSuccessful(kid: Model.Kid)

        fun showProgress()
        fun hideProgress()
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun addChild(kid: Model.Kid)
    }
}