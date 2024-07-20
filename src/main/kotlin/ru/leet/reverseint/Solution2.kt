package ru.leet.reverseint

class Solution2 {

    fun reverse(x: Int): Int {
        var rev = 0
        var original = x
        while (original != 0) {
            val rest = original % 10
            original /= 10
            if (rev <= Int.MAX_VALUE / 10 && rev >= Int.MIN_VALUE / 10) {
                rev = (rev * 10) + rest
            } else {
                rev = 0
                break
            }
        }
        return rev
    }
}

fun main() {
    println(Solution2().reverse(-2_147_483_412))
    println(Solution2().reverse(1463847412))
    println(Solution2().reverse(Int.MIN_VALUE + 1))
    println(Solution2().reverse(Int.MIN_VALUE))
    println(Solution2().reverse(1_000_000_002))
    println(Solution2().reverse(Int.MAX_VALUE))
    println(Solution2().reverse(Int.MIN_VALUE))
    println(Solution2().reverse(Int.MIN_VALUE + 1))
    println(Solution2().reverse(120))
    println(Solution2().reverse(Int.MAX_VALUE - 2))
    println(Solution2().reverse(1_000_000_003))
    println(Solution2().reverse(1_000_000_002))
    println(Solution2().reverse(1_000_000_001))
    println(Solution2().reverse(1_000_000_000))
    println(Solution2().reverse(-120))
    println(Solution2().reverse(123))
}
