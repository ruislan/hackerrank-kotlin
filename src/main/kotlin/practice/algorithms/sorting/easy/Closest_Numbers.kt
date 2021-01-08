package practice.algorithms.sorting.easy

import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val n = scan.nextLine().trim().toInt()
    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    // 方法1
    // 首先排序
    // 然后找出相邻的两个数字的差最小的那个
    // 如果还有更小的，就清空，放入更小的
    // 其实可以直接用arr.sort()的， 但是我就是手痒就写了个快速排序：）
    sort(arr, 0, n - 1)
    val lists = ArrayList<Int>()
    var min = Int.MAX_VALUE
    for (i in 1 until n) {
        val diff = arr[i] - arr[i - 1]
        if (diff < min) {
            min = diff
            lists.clear()
            lists.add(arr[i - 1])
            lists.add(arr[i])
        } else if (diff == min) {
            lists.add(arr[i - 1])
            lists.add(arr[i])
        }
    }
    println(lists.joinToString(" "))
}

fun sort(arr: Array<Int>, lo: Int, hi: Int) {
    if (lo < hi) {
        val pivot = partition(arr, lo, hi)
        sort(arr, lo, pivot)
        sort(arr, pivot + 1, hi)
    }
}

fun partition(arr: Array<Int>, lo: Int, hi: Int): Int {
    val x = arr[lo + (hi - lo) / 2]
    var i = lo
    var j = hi
    while (true) {
        while (arr[i] < x) i += 1
        while (arr[j] > x) j -= 1
        if (i >= j) return j
        arr[i] = arr[j].also { arr[j] = arr[i] }
        i += 1
        j -= 1
    }
}