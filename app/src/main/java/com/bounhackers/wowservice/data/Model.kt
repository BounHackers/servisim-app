package com.bounhackers.wowservice.data

object Model {
    data class Parent(val id: Long,
                      val name: String,
                      val location: String,
                      val username: String,
                      val created_at: String?,
                      val updated_at: String?,
                      val kids: List<Kid>?)

    data class Kid(val id: Long,
                   val name: String,
                   val location: String?,
                   val username: String,
                   val parent: Parent,
                   val routes: List<Route>,
                   val schools: List<School>)

    data class Driver(val id: Long,
                      val school_id: Long,
                      val username: String,
                      val created_at: String,
                      val updated_at: String)

    data class Route(val id: Long,
                     val driver: Driver,
                     val kids: List<Kid>,
                     val startTime: Long)

    data class School(val id: Long,
                      val name: String,
                      val location: String,
                      val created_at: String,
                      val updated_at: String)

    data class Vehicle(val id: String,
                       val licenseplate: String,
                       val finorvin: String)
}