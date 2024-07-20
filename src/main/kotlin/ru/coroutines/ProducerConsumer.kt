package ru.coroutines

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit

class ProducerConsumer {

    val byteArrayFrom = ByteArray(10).map { 1.toByte() }.toByteArray()
    val byteArrayTo = ByteArray(20)

    fun pump() {
        val q = LinkedBlockingQueue<Byte>()
        val consumer = Thread() {
            var i = 0
            while(i < byteArrayTo.size) {
                val byte = q.poll(2, TimeUnit.SECONDS) ?: break
                byteArrayTo[i] = byte
                i++
            }
        }
        val producer = Thread() {
            var i = 0
            while (i < byteArrayFrom.size) {
                q.put(byteArrayFrom[i])
                byteArrayFrom[i] = 0.toByte()
                i++
                Thread.sleep(1600)
            }
        }
        println(byteArrayTo.asList())
        println(byteArrayFrom.asList())
        println(q)
        consumer.start()
        producer.start()
        Thread.sleep(2500)
        println(byteArrayTo.asList())
        println(byteArrayFrom.asList())
        println(q)
    }
}

fun main() {
    ProducerConsumer().pump()
}



