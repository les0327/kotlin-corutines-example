package com.les

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

// 1 message is consumed by 1 job at a time
fun main() {
    runBlocking {
        val resourceUrl = object {}.javaClass.classLoader.getResource("./file.txt") ?: throw RuntimeException("file.txt is not found")

        resourceUrl.openStream()
            .bufferedReader()
            .lineSequence()
            .asFlow()
            .flowOn(Dispatchers.IO)
            .collect {
                println(it)
            }
    }
}