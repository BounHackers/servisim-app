package com.bounhackers.wowservice.data

object Model {
    data class Parent(val id: Long,
                      val name: String,
                      val location: String,
                      val username: String,
                      val password: String,
                      val created_at: String,
                      val updated_at: String)

    data class Kid(val id: Long,
                   val name: String,
                   val location: String,
                   val username: String,
                   val password: String,
                   val parent_id: Long,
                   val created_at: String,
                   val updated_at: String)

    data class Driver(val id: Long,
                      val school_id: Long,
                      val username: String,
                      val password: String,
                      val created_at: String,
                      val updated_at: String)

    data class Route(val id: Long,
                     val kid_id: Long,
                     val created_at: String,
                     val updated_at: String)

    data class School(val id: Long,
                      val name: String,
                      val location: String,
                      val created_at: String,
                      val updated_at: String)
}