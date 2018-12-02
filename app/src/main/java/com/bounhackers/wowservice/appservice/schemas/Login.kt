package com.bounhackers.wowservice.appservice.schemas

object Login {
    data class LoginRequestBody(val username: String, val password: String)
}