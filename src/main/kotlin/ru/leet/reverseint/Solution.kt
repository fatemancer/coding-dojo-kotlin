package ru.leet.reverseint

import kotlin.math.max

class Solution {
    fun reverse(x: Int): Int {
        // отрицательное число
        // число больше лимита
        // число с 0 в начале
        val isNegative =  x < 0

        val direct: CharArray = x.toString().toCharArray()
        val reversed = CharArray(10) // max size int
        var firstProcessed = true
        var idx = 0
        if (x == 0) {
            return 0
        }
        for (c in direct.size - 1 downTo 0) {
            if (firstProcessed && direct[c] == '0') {
                continue
            } else {
                if (direct[c] != '-') {
                    reversed.set(idx, direct[c])
                    idx++
                    firstProcessed = false
                }
            }
        }
        return postProcess(reversed, isNegative)
    }

    fun postProcess(reversed: CharArray, isNegative: Boolean): Int {
        val minimumC = Int.MIN_VALUE.toString().trimStart('-')
        val maximumC = Int.MAX_VALUE.toString()
        val sb = StringBuilder()

        for (c in reversed) {
            if (c.isDigit()) {
                sb.append(c)
            }
        }

        val candidate = sb.toString()

        if (isNegative) {
            if (candidate > minimumC && candidate.length >= 10) {
                return 0
            } else {
                return -candidate.toInt()
            }
        } else {
            if (candidate > maximumC && candidate.length >= 10) {
                return 0
            } else {
                return candidate.toInt()
            }
        }
    }
}

fun main() {
    println(Solution().reverse(-2_147_483_412))
    println(Solution().reverse(Int.MIN_VALUE + 1))
    println(Solution().reverse(Int.MIN_VALUE))
    println(Solution().reverse(1_000_000_002))
    println(Solution().reverse(Int.MAX_VALUE))
    println(Solution().reverse(Int.MIN_VALUE))
    println(Solution().reverse(Int.MIN_VALUE + 1))
    println(Solution().reverse(120))
    println(Solution().reverse(Int.MAX_VALUE - 2))
    println(Solution().reverse(1_000_000_003))
    println(Solution().reverse(1_000_000_002))
    println(Solution().reverse(1_000_000_001))
    println(Solution().reverse(1_000_000_000))
    println(Solution().reverse(-120))
    println(Solution().reverse(123))
}
