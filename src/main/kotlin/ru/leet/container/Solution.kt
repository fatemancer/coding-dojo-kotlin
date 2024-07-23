package ru.leet.container

import java.lang.Integer.min

class Solution {

    fun maxArea(height: IntArray): Int {

        var containerStart = 0
        var containerEnd = height.size - 1
        var maxArea = 0

        var currLeft = 0
        var currRight = height.size - 1
        while (currRight >= 0) {
            maxArea = Math.max(maxArea, area(currLeft, currRight, height))
            if (height[currLeft] < height[currRight]) {
                currLeft++
            } else {
                currRight--
            }
        }

        return maxArea
    }


//    fun startNewAreaFinder(containerStart: Int, containerEnd: Int) {
//        while(containerStart < height.size) {
//            containerEnd++
//            var dim = min(containerStart, containerEnd)
//            var area = dim * dim
//            if (area > maxArea) {
//                maxArea = area
//            }
//        }
//    }
}

fun area(currLeft: Int, currRight: Int, height: IntArray): Int {
    var dim = min(height[currLeft], height[currRight])
    var diff = Math.abs(currRight - currLeft)
    var area = dim * diff
    //println("$dim * $diff")
    return area
}

fun main() {
    val s = Solution()
    s.maxArea(intArrayOf(1,8,100,2,100,4,8,3,7)).also { println(it) }
    s.maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)).also { println(it) }
    s.maxArea(intArrayOf(1,1)).also { println(it) }
    s.maxArea(intArrayOf(2,3,4,5,18,17,6)).also { println(it) } // 17
    s.maxArea(intArrayOf(1,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)).also { println(it) }
    s.maxArea(intArrayOf(2,1,1,1,1,1,1,1,1,1,8,6,2,5,4,8,3,7,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2)).also { println(it) }
}



fun maxArea(height: IntArray): Int {

    var i = 0
    var maxArea = 0
    while(i < height.size) {
        var containerStart = i
        var containerEnd = i
        while(containerEnd < height.size - 1) {
            containerEnd++
            var dim = min(height[containerStart], height[containerEnd])
            var diff = (containerEnd - containerStart)
            var area = dim * diff
            // println("$dim * $diff")
            if (area > maxArea) {
                maxArea = area
            }
        }
        i++
    }
    return maxArea
}
