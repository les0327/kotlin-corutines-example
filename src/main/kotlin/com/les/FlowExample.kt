package com.les

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() : Unit = runBlocking {
    helloWorld()
        .onEach { print(it) }
        .onStart { println("Flow started") }
        .onCompletion { println("Flow finished") }
        .collect()

    withTimeout(500L) {
        helloWorld()
            .onEach { print(it) }
            .onStart { println("Flow started") }
            .onCompletion { println("Flow finished") }
            .collect()
    }
}

fun helloWorld(): Flow<String> = flow {
    emit("Hello ")
    delay(1000L)
    emit("World!\n")
}