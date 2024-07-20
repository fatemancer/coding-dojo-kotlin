package ru.leet.zigzag

import java.util.*

class Solution {
    fun convert(s: String, numRows: Int): String {
        val arr = s.toCharArray()
        val shift = (numRows - 1) * 2
        var resp = mutableListOf(sortedSetOf<Int>())
        var width = 0

        if (numRows == 1) {
            return s
        }

        for (row in 0 until numRows) {
            width = fillOnlyVerticals(row, arr, shift, resp)
            if (!(row == 0 || row == numRows - 1)) {
                fillWithDiagonals(width, row, numRows, shift, arr, resp)
            }
        }
        return resp.map { it.map { el -> arr.get(el) }.joinToString("") }.joinToString("")
    }

    private fun fillWithDiagonals(
        width: Int,
        row: Int,
        numRows: Int,
        shift: Int,
        arr: CharArray,
        resp: MutableList<TreeSet<Int>>
    ) {
        val coef = (numRows - row - 1) * 2
        for (i in 0..width - 1) {
            resp.get(row).let {
                val shifted = row + coef + (i * shift)
                if (shifted < arr.size) {
                    it.add(shifted)
                }
            }
        }
    }

    private fun fillOnlyVerticals(row: Int, arr: CharArray, shift: Int, resp: MutableList<TreeSet<Int>>): Int {
        var width = 0
        var idx = 0 + row
        resp.getOrNull(row).let { cr ->
            if (cr == null) {
                val element = sortedSetOf<Int>()
                resp.add(row, element)
                element
            } else {
                cr
            }
        }.apply {
            while (arr.getOrNull(idx) != null) {
                add(idx)
                idx += shift
                width++
            }
        }
        return width
    }
}

fun main() {
    Solution().convert("PAYPALISHIRING", 3).let {
        print("PAHNAPLSIIGYIR" == it)
        println(" -> $it")
    }
    Solution().convert("PAYPALISHIRING", 4).let {
        print("PINALSIGYAHRPI" == it)
        println(" -> $it")
    }
    Solution().convert("PAYPALISHIRING", 5).let {
        print("PINALSIGYAHRPI" == it)
        println(" -> $it")
    }
    Solution().convert("PAYPALISHIRING", 6).let {
        print("PINALSIGYAHRPI" == it)
        println(" -> $it")
    }
}
// 14 символов
//


/**
 * for (i in 0..numRows) {
val shift = ((numRows - 1) * 2) - (i * 2)
var idx = 0 + i
while (true) {
var char = arr.getOrNull(idx)
if (char == null) {
break
} else {
resp += char
}
idx += shift

}
}
 */

/**
 *
var resp = ""
val arr = s.toCharArray()
if (numRows == 1) {
return s
}
for (row in 0 until numRows) {
var shift = ((numRows - 1) * 2) - (row * 2)
if (row == numRows - 1) {
shift = ((numRows - 1) * 2)
}
var idx = 0 + row
while (true) {
var char = arr.getOrNull(idx)
if (char == null) {
println(resp)
break
} else {
resp += char
}
idx += shift
}
}
 */

/*
var resp = mutableListOf(sortedSetOf<Int>())
        val arr = s.toCharArray()
        if (numRows == 1) {
            return s
        }
        for (writingRow in 0 until numRows) {
            val set = sortedSetOf<Int>()
            var idx = writingRow
            while (true) {
                val char = arr.getOrNull(idx)
                val shift = (numRows - 1) * 2
                if (char == null) {
                    resp.add(writingRow, set)
                    break
                } else {
                    set.add(idx)


                }
                idx += shift
            }
            println(resp)
 */


/* 1 -> 0 */

/* 2 -> 2
P   P   I
A Y A L S
*/

/* 3 -> 4
P   A   H   N
A P L S I I G
Y   I   R
 */

/* 4
0   4   8    12
1 3 5 7 9 11 13
2   6   10
 */

/* 4 -> 6
P     I    N
A   L S  I G
Y A   H R
P     I

P I N
ALSIG
YAHR
P I

0    6      12
1  5 7   11 13
2 4  8 10
3    9
 */

/* 5 -> 8
P       H
A     S I
Y   I   R
P L     I G
A       N
 */
