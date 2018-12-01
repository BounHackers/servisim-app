package com.bounhackers.wowservice.appservice.schemas

object Kid {
    data class RegisterKidRequest(val name: String,
                                  val location: String?,
                                  val username: String,
                                  val password: String,
                                  val parent_id: Long)
}