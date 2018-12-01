package com.bounhackers.wowservice.appservice.schemas

object Parent {
    data class RegisterParentRequest(val name: String,
                                     val location: String?,
                                     val username: String,
                                     val password: String)
}