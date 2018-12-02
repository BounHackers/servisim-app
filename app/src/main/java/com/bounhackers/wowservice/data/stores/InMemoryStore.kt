package com.bounhackers.wowservice.data.stores

abstract class InMemoryStore<T> {

    private val dataMap: MutableMap<Long, T> = LinkedHashMap()

    fun getData(id: Long): T? {
        return dataMap.get(id)
    }

    fun put(id: Long, data: T) {
        dataMap.put(id, data)
    }

}