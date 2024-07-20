package ru.coroutines

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock

class Robot {
    // one step at a time
    val lock = ReentrantLock()
    val leftCondition = lock.newCondition()
    val rightCondition = lock.newCondition()
    val left = Leg("left")
    val right = Leg("right")
    val order = listOf(leftCondition, rightCondition)

    fun walk() {
        Thread(make10Steps(left, leftCondition)).start()
        Thread(make10Steps(right, rightCondition)).start()
        lock.lock()
        leftCondition.signal()
        lock.unlock()
    }

    private fun make10Steps(leg: Leg, condition: Condition): () -> Unit = {
        try {
            for (i in 0..100) {
                lock.lock()
                val success = condition.await(1, TimeUnit.SECONDS)
                if (!success) {
                    continue
                }
                leg.step()
                order.first { it != condition }.signal()
            }
        } finally {
            lock.unlock()
        }
    }

}

class Leg(
    val name: String
) {
    fun step() {
        Thread.sleep((Math.random() * 50).toLong())
        println("$name!")
    }
}

fun main() {
    Robot().walk()
}
