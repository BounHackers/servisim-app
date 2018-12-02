package com.bounhackers.wowservice.data.stores

import com.bounhackers.wowservice.data.Model

class InMemoryParentStore: InMemoryStore<Model.Parent>() {

    companion object {

        private val instance: InMemoryParentStore = InMemoryParentStore()

        fun getInstance(): InMemoryParentStore {
            return instance
        }
    }
}