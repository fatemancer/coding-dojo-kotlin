package ru.leet.roman

class Solution {

    fun intToRoman(num: Int): String {
        // 1 < x < 3999

        /*
        Input: num = 3749

        Output: "MMMDCCXLIX"

        749
        DCCXLIX

        409
        CDIX         */

        var number = num
        var digits = number % 10
        number /= 10
        var tens = number % 10
        number /= 10
        var hundred = number % 10
        number /= 10
        var thousands = number % 10
        number /= 10

        val sb = StringBuilder()
        sb.append("M".repeat(thousands))
        // MMM

        sb.append(doConvert("D", "M", "C",  hundred))
        // MMMDCC
        sb.append(doConvert("L", "C", "X",  tens))
        // MMMDCCXL
        sb.append(doConvert("V", "X", "I",  digits))
        // MMMDCCXLIX

        return sb.toString()
    }

    private fun doConvert(five: String, ten: String, one: String, amount: Int): String {
        val sb = StringBuilder()
        if (amount == 4) {
            sb.append(one + five)
        } else if (amount == 9) {
            sb.append(one + ten)
        } else if (amount >= 5) {
            sb.append(five + one.repeat(amount - 5))
        } else sb.append(one.repeat(amount))
        return sb.toString()
    }
}

fun main() {
    Solution().intToRoman(3749).also { println(it) }
}
