package ru.gpt

class Multithreading1 {


}

fun main1() {
    val thread = Thread {
        println("Thread running: ${Thread.currentThread().name}")
    }
    thread.start()
    println("Main thread: ${Thread.currentThread().name}")
}

class MyRunnable : Runnable {
    override fun run() {
        println("Runnable running: ${Thread.currentThread().name}")
    }
}

fun main2() {
    val runnable = MyRunnable()
    val thread = Thread(runnable)
    thread.start()
    println("Main thread: ${Thread.currentThread().name}")
}

var counter = 0

@Synchronized fun increment() {
    counter++
}

fun main() {
    val threads = List(100) {
        Thread {
            repeat(1000) {
                increment()
            }
        }
    }

    threads.forEach { it.start() }
    threads.forEach { it.join() }

    println("Counter: $counter")
}
