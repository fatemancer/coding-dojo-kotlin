package ru.coroutines

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock


fun a() {
    println("a")
}

suspend fun b() {
    println("b")
}

fun main() {
    val lock = ReentrantLock()
    val until = 20
    for (i in 0 until 20) {
        Thread().run {
            advance(lock)
        }
        Thread().run {
            advance(lock)
        }
    }

}

fun advance(lock: Lock) {


}
