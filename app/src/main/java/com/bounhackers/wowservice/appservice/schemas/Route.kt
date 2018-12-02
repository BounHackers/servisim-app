package com.bounhackers.wowservice.appservice.schemas

import com.bounhackers.wowservice.data.Model

object Route {
    data class CreateRouteRequest(val driver_id: Long,
                                  val start_time: Long,
                                  val kid_ids: List<Long>)

    data class UpdateRouteRequest(val driver_id: Long?,
                                  val start_time: Long?,
                                  val kid_ids: List<Long>?,
                                  val late_kids: String?)
}