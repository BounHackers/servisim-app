package com.bounhackers.wowservice.appservice.schemas

object School {
    data class CreateSchoolRequest(val name: String,
                                   val location: String?)
}