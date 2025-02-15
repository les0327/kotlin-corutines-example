package com.les

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

fun main(): Unit = runBlocking {
    val counter = AtomicInteger(0)

    val timeSpent = measureTimeMillis {
        val job1 = launch {
            for (i in 1..1000) {
                counter.getAndIncrement()
            }
        }

        val job2 = launch {
            for (i in 1..1000) {
                counter.getAndIncrement()
            }
        }

        job1.join()
        job2.join()
    }

    println("Counter = $counter, time spent = ${timeSpent}ms")
}
