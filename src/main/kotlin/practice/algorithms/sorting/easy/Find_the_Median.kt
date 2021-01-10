package practice.algorithms.sorting.easy

import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val n = scan.nextLine().trim().toInt()
    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    // 方法1
    // 排序方法这里只能是O(nlogn)水平的，因为数据会比较大
    // Passed
    arr.sort()
    println(arr[arr.size / 2])
}