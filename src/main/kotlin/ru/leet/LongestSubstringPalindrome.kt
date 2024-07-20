package ru.leet

fun main() {
    println(Solution().longestPalindrome("cbbd"))
    println(Solution().longestPalindrome("a"))
    println(Solution().longestPalindrome("babad"))
    println(Solution().longestPalindrome("acabaab"))
    println(Solution().longestPalindrome(""))
    println(Solution().longestPalindrome("baaaab"))
    println(Solution().longestPalindrome("baaab"))
}

class Solution {

    //

    fun longestPalindrome(str: String): String {
        val arr = str.toCharArray()
        var pali = ""
        if (str.length == 1) {
            return str
        }
        // cbbd -> bb, babad -> bab || aba, acabaab -> baab
        for (idx in 1..arr.size - 1) {
            tryCentralSymmetry(arr, idx).let { central ->
                if (central.length > pali.length) {
                    pali = central
                }
            }
            tryEvenSymmetry(arr, idx).let { even ->
                if (even.length > pali.length) {
                    pali = even
                }
            }

        }
        return pali
    }

    private fun tryEvenSymmetry(arr: CharArray, idx: Int): String {
        var candidate = ""
        var leftShift = -1
        var rightShift = 0
        while (true) {
            var left = arr.getOrNull(idx + leftShift) ?: ""
            var right = arr.getOrNull(idx + rightShift) ?: ""
            if (left == right && !(left == "" && right == "")) {
                candidate = "$left$candidate$right"
                leftShift -= 1
                rightShift += 1
            } else {
                return candidate

            }
        }
    }

    private fun tryCentralSymmetry(arr: CharArray, idx: Int): String {
        var candidate = arr.get(idx).toString()
        var leftShift = -1
        var rightShift = 1
        while (true) {
            var left = arr.getOrNull(idx + leftShift) ?: ""
            var right = arr.getOrNull(idx + rightShift) ?: ""
            if (left == right && !(left == "" && right == "")) {
                candidate = "$left$candidate$right"
                leftShift -= 1
                rightShift += 1
            } else {
                return candidate
            }
        }
    }

}
