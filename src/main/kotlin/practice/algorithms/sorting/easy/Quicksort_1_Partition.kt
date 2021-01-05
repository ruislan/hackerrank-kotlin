package practice.algorithms.sorting.easy

import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val n = scan.nextLine().trim().toInt()
    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    // 方法1
    // 先按照题目的意思用额外的两个集合来存储吧
    // Passed
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()
    for (i in 1 until n) {
        if (arr[i] > arr[0]) {
            right.add(arr[i])
        } else {
            left.add(arr[i])
        }
    }
    left.add(arr[0])
    left.addAll(right)
    println(left.joinToString(" "))
}
