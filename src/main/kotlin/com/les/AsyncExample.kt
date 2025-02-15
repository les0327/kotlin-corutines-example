package com.les

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val cor1 = async(start = CoroutineStart.LAZY) {
        println("Lazy")
        hello()
    }

    val cor2 = async {
        println("Not Lazy")
        world()
    }

    print("${cor1.await()} ${cor2.await()}")
}

fun world(): String {

    return "World!"
}

suspend fun hello(): String {
    delay(1000L)
    return "Hello"
}