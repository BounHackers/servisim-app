package com.bounhackers.wowservice.appservice.schemas

object Vehicle {
    data class Location(val longitude: LocationValue, val latitude: LocationValue, val heading: LocationValue)
    data class LocationValue(val value: Double, val retrievalstatus: String, val timestamp: Long)
}