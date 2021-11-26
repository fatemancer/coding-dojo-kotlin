package ru.technicalExcellence.codingDojo

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HelloWorldShould {

    @Test
    fun returnHelloWorld() {
        val expected = "Hello World"

        val actual = HelloWorld().helloWorld()

        assertEquals(expected, actual)
    }
}

