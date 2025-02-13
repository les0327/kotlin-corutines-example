package com.les

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 1 message is consumed by 1 job at a time
fun main() {
    runBlocking {
        val channel = Channel<Int>()

        launch {
            for (i in 0..10) {
                channel.send(i)
                println("Send $i")
                delay(100)
            }

            channel.close()
        }

        launch {
            channel.consumeEach {
                println("Job 1 Received $it")
            }
        }

        launch {
            channel.consumeEach {
                println("Job 2 Received $it")
            }
        }
    }
}