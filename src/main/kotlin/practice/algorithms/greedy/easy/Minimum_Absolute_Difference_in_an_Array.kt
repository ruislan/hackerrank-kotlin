package practice.algorithms.greedy.easy

import kotlin.math.*

fun main() {
    val n = readLine()!!.trim().toInt()
    val arr = readLine()!!.trim().split(" ").map { it.trim().toInt() }.toTypedArray()
    // 方法1
    // 排序后两个相邻的数字的绝对值这个数字和其他所有数字中最小的
    // 因为离得最近的距离最短
    // 然后找出所有相邻的两个数字的绝对值的最小的那个就行了
    // Passed
    arr.sort()
    var min = Int.MAX_VALUE
    for (i in 1 until n) {
        min = min(min, abs(arr[i] - arr[i - 1]))
    }
    println(min)
}
