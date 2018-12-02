package com.bounhackers.wowservice.data.stores

import com.bounhackers.wowservice.data.Model

class LoggedInUserStore {

    private var loggedInEntity: Any? = null

    fun getLoggedInEntity(): Any? = loggedInEntity

    fun setLoggedInParent(parent: Model.Parent) {
        loggedInEntity = parent
    }

    fun setLoggedInKid(kid: Model.Kid) {
        loggedInEntity = kid
    }

    fun setLoggedInDriver(driver: Model.Driver) {
        loggedInEntity = driver
    }

    companion object {

        private val instance: LoggedInUserStore = LoggedInUserStore()

        fun getInstance(): LoggedInUserStore {
            return instance
        }
    }
}