package ru.technicalExcellence.codingDojo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HelloWorldShould {

    @Test
    fun `Sum of Squared Inputs`() {
        assertEquals(5, squareSum(arrayOf(1, 2)))
        assertEquals(50, squareSum(arrayOf(0, 3, 4, 5)))
        assertEquals(0, squareSum(arrayOf()))
    }

    private fun squareSum(arrayOf: Array<Int>): Int = arrayOf.sumOf { it * it }
}

