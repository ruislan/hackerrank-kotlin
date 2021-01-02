package practice.algorithms.sorting.easy

import java.util.*

fun main() {
    val scan = Scanner(System.`in`)
    val n = scan.nextLine().trim().toInt()
    val arr = scan.nextLine().trim().split(" ").map { it.trim().toInt() }.toTypedArray()

    // 方法1
    // 使用swap
    // Passed
    for (i in 1 until n) {
        var j = i
        while (j > 0 && arr[j - 1] > arr[j]) {
            arr[j] = arr[j - 1].also { arr[j - 1] = arr[j] }
            j -= 1
        }
        println(arr.joinToString(" "))
    }

    // 方法2
    // 使用shift
    // Passed
    for (i in 1 until n) {
        val x = arr[i]
        var j = i
        while (j > 0 && arr[j - 1] > x) {
            arr[j] = arr[j - 1]
            j -= 1
        }
        arr[j] = x
        println(arr.joinToString(" "))
    }
}