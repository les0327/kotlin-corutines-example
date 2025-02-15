package com.les

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.system.measureTimeMillis

fun main(): Unit = runBlocking {
    var counter = 0;
    val mutex = Mutex()

    val timeSpent = measureTimeMillis {
        val job1 = launch {
            for (i in 1..1000) {
                mutex.withLock {
                    counter++;
                }
            }
        }

        val job2 = launch {
            for (i in 1..1000) {
                mutex.withLock {
                    counter++;
                }
            }
        }

        job1.join()
        job2.join()
    }

    println("Counter = $counter, time spent = ${timeSpent}ms")
}
