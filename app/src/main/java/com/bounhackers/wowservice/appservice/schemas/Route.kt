package com.bounhackers.wowservice.appservice.schemas

object Route {
    data class CreateRouteRequest(val driver_id: Long,
                                  val start_time: Long,
                                  val kid_ids: List<Long>)

    data class UpdateRouteRequest(val driver_id: Long?,
                                  val start_time: Long?,
                                  val kid_ids: List<Long>?,
                                  val late_kids: String?)
}