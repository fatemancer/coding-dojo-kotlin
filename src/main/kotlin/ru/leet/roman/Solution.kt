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

        sb.append(doConvert("D", "M", "C", hundred))
        // MMMDCC
        sb.append(doConvert("L", "C", "X", tens))
        // MMMDCCXL
        sb.append(doConvert("V", "X", "I", digits))
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

    fun romanToInt(s: String): Int {
        val arr = s.toCharArray()
        val digits = intArrayOf(0, 0, 0, 0)
        var idx = 0
        while (true) {
            val char = arr[idx]
            if (char in setOf('I', 'X', 'C') && idx < s.length - 1) {
                val nextChar = arr[idx + 1]
                val cx = charArrayOf(char, nextChar).concatToString()
                when (cx) {
                    "IV" -> {
                        digits[3] += 4; idx++
                    }
                    "IX" -> {
                        digits[3] += 9; idx++
                    }
                    "XL" -> {
                        digits[2] += 4; idx++
                    }
                    "XC" -> {
                        digits[2] += 9; idx++
                    }
                    "CD" -> {
                        digits[1] += 4; idx++
                    }
                    "CM" -> {
                        digits[1] += 9; idx++
                    }
                    else -> {
                        toInt(char, digits)
                    }
                }
            } else {
                toInt(char, digits)
            }

            idx++
            if (idx == s.length) {
                break
            }
        }
        return digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3]
    }

    fun toInt(c: Char, digits: IntArray) {
        when (c) {
            'I' -> digits[3] += 1
            'V' -> digits[3] += 5
            'X' -> digits[2] += 1
            'L' -> digits[2] += 5
            'C' -> digits[1] += 1
            'D' -> digits[1] += 5
            'M' -> digits[0] += 1
            else -> throw IllegalArgumentException("not a roman numeral")
        }
    }

}

fun main() {
    Solution().intToRoman(3749).also { println(it) }
}
