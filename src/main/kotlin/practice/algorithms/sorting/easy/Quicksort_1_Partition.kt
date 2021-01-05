package practice.algorithms.sorting.easy

import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val n = scan.nextLine().trim().toInt()
    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    // 方法1
    // 两个集合来存储
    // Passed
//    val left = mutableListOf<Int>()
//    val right = mutableListOf<Int>()
//    for (i in 1 until n) {
//        if (arr[i] > arr[0]) {
//            right.add(arr[i])
//        } else {
//            left.add(arr[i])
//        }
//    }
//    left.add(arr[0])
//    left.addAll(right)
//    println(left.joinToString(" "))

    // 方法2
    // 不用额外的集合存储
    // 左右分别找到比其大和小的，然后交换
    // 直到左右交错
    // Passed
    if (n > 1) {
        val pivot = arr[0]
        val lo = 1
        val hi = n - 1
        var i = lo
        var j = hi
        while (true) {
            while (i < hi && arr[i] < pivot) i += 1
            while (j > 0 && arr[j] > pivot) j -= 1
            if (i >= j) break
            arr[i] = arr[j].also { arr[j] = arr[i] }
            i += 1
            j -= 1
        }
        arr[j] = arr[0].also { arr[0] = arr[j] }
    }
    println(arr.joinToString(" "))
}
