package ru.leet.atoi

class Solution {
    /**
     *
    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

    The algorithm for myAtoi(string s) is as follows:

    Whitespace: Ignore any leading whitespace (" ").
    Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
    Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
    Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
    Return the integer as the final result.
     */

    fun myAtoi(s: String): Int {
        var negative: Int? = null
        var whitespaces = true
        var result = 0
        for (c in s.toCharArray()) {
            if (c == ' ' && whitespaces) {
                continue
            } else {
                whitespaces = false
            }
            if (negative == null) {
                if (c == '-') {
                    negative = -1
                    continue
                }
                if (c == '+') {
                    negative = 1
                    continue
                }
                else negative = 1
            }
            if (c.isDigit()) {
                if (result * negative > (Int.MAX_VALUE - c.digitToInt()) / 10) {
                    return Int.MAX_VALUE
                }
                if (result * negative < (Int.MIN_VALUE + c.digitToInt()) / 10) {
                    return Int.MIN_VALUE
                }
                result = (result * 10) + c.digitToInt()
            } else {
                break
            }
        }
        return result * (negative ?: 1)
    }
}

fun main() {
    Solution().myAtoi("2147483648").let { println(it) }
    Solution().myAtoi("42").let { println(it) }
    Solution().myAtoi("2147483646").let { println(it) }
    Solution().myAtoi("   +0 123").let { println(it) }
    Solution().myAtoi("+42").let { println(it) }
    Solution().myAtoi("-42").let { println(it) }
    Solution().myAtoi("-42d").let { println(it) }
    Solution().myAtoi("-4200000000").let { println(it) }
    Solution().myAtoi("4200000000").let { println(it) }
    Solution().myAtoi("-1200000+00").let { println(it) }
    Solution().myAtoi("    56").let { println(it) }
    Solution().myAtoi("    -56").let { println(it) }
    Solution().myAtoi("   -").let { println(it) }
    Solution().myAtoi("ddddd56").let { println(it) }

}
