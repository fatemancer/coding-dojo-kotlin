package ru.technicalExcellence

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HelloWorldShould {

    @Test
    fun returnHelloWorld() {
        val helloWorld = HelloWorld();
        assertEquals("Hello World", helloWorld.helloWorld())
    }
}

