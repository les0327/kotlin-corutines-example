package com.les

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 1 message is consumed by all subscribers at a time
fun main() {
    runBlocking {
        val flow = MutableSharedFlow<Int>()

        launch {
            for (i in 0..10) {
                flow.emit(i)
                println("Send $i")
                delay(100)
            }
        }

        launch {
            flow.collect {
                println("Job 1 Received $it")
            }
        }

        launch {
            flow.collect {
                println("Job 2 Received $it")
            }
        }

        delay(500L)

        println("Flow subscription count ${flow.subscriptionCount.value}")
    }
}