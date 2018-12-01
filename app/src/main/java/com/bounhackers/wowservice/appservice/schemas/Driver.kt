package com.bounhackers.wowservice.appservice.schemas

object Driver {
    data class CreateDriverRequest(val school_id: Long,
                                   val username: String,
                                   val password: String)
}