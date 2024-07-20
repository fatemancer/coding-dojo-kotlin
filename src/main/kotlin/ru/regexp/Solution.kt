package ru.regexp

import java.util.*

class Solution {

    fun isMatch(s: String, p: String): Boolean {
        println("s: $s, p: $p")
        val chars = s.toCharArray()
        val stack = Stack<Char>()
        for (element in p) {
            stack.push(element)
        }

        var skip: Char? = null
        var matched = 0

        var idx = chars.size - 1
        while (matched != s.length) {

            val letter = chars[idx]

            if (skip == letter || skip == '.') {
                matched++
                idx--
                continue
            }

            if (stack.isEmpty()) {
                return false
            } else {
                val rx = stack.pop()
                skip = null
                when (rx) {
                    letter -> {  matched++; idx-- }
                    '.' -> { matched++; idx-- }
                    '*' -> {
                        val actual = stack.pop()
                        if (actual == letter || actual == '.') {
                            skip = actual
                            matched++
                        }
                    }
                    else -> return false
                }

            }

        }
        print(stack)
        return true
    }
}

// adddc -> cddda
// [ c, *, a ]
// [ c, *, . , a ]


fun main() {
    val s = Solution()
    s.isMatch("aaa", "ab*ac*a").also { println(it == true) }
    s.isMatch("aaa", "ab*a").also { println(it == false) }

    s.isMatch("mississippi", "mis*is*ip*.").also { println(it == true) }
    s.isMatch("aaa", "aaaa").also { println(it == false) }
    s.isMatch("aa", "aa").also { println(it == true) }
    s.isMatch("aa", "a*").also { println(it == true) }
    s.isMatch("ab", ".*").also { println(it == true) }
    s.isMatch("aa", "a").also { println(it == false) }
    s.isMatch("aaaaaac", "a*c").also { println(it == true) }
    s.isMatch("aaaaaacd", "a*c").also { println(it == false) }
    s.isMatch("a", "a*").also { println(it == true) }

    s.isMatch("addddc", "a.*c").also { println(it == true) }
    s.isMatch("addaddc", "a.*c").also { println(it == true) }
    s.isMatch("adddd", "a.*").also { println(it == true) }
    s.isMatch("aab", "c*a*b").also { println(it == true) }
}


/*
        val chars = s.toCharArray()
        val stack = Stack<Char>()
        for (idx in p.length - 1 downTo 0) {
            stack.push(p[idx])
        }
        var rx: Char
        var last: Char = chars.first()
        var star = false
        for (idx in chars.size - 1 downTo 0) {
            val c = chars[idx]
            if (star) {
                if (c != last) {
                    star = false
                }
                last = c
                continue
            }
            if (!stack.isEmpty()) {
                rx = stack.pop()
                if (rx == c) {
                    last = c
                    continue
                } else {
                    if (rx == '*') {
                        star = true
                        continue
                    }
                    if (rx == '.') {
                        last = '.'
                        continue
                    }
                    else {
                        return false
                    }
                }
            } else {
                return false
            }
        }
        return !stack.isEmpty()
 */
