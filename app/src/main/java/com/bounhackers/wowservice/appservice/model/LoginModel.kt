package com.bounhackers.wowservice.appservice.model

object LoginModel {
    data class LoginRequestBody(val username: String, val password: String)
    data class LoginResponse(val token: String)
}