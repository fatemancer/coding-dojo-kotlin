package ru.leet.number_palindrome

class Solution {
    fun isPalindrome(x: Int): Boolean {
        var original = x
        if (x < 0) {
            return false
        }
        var inverted = 0
        while (original != 0) {
            val rest = original % 10
            original /= 10
            inverted = (inverted * 10) + rest
        }
        return inverted == x
    }
}

fun main() {
    Solution().isPalindrome(120).let { println(it) }
    Solution().isPalindrome(121).let { println(it) }
    Solution().isPalindrome(-121).let { println(it) }
    Solution().isPalindrome(10).let { println(it) }
    Solution().isPalindrome(20022002).let { println(it) }
    Solution().isPalindrome(200212002).let { println(it) }
}
