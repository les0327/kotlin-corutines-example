package com.les

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val cor1 = launch {
        delay(1000L)
        println("World!")
    }

    val cor2 = launch {
        print("Hello ")
    }

    cor1.join()
    cor2.join()

    print("Done")
}