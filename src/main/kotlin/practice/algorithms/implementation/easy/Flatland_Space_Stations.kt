package practice.algorithms.implementation.easy

import java.util.*

// Complete the flatlandSpaceStations function below.
fun flatlandSpaceStations(n: Int, c: Array<Int>): Int {
    // 方法1
    // 首先，c不是有序的，所以我们有序一下
    // 然后我们取三个段，第一个段是city[0]到station[0]的距离
    // 第二个段是(station[i] - station[i - 1]) / 2 中最大的那个
    // 第三个段是station.last()到city.last()的距离
    // 然后三个段中最大的那个返回
    // Passed
    var max = 0
    c.sort()
    for (i in 1 until c.size) {
        max = Math.max(max, c[i] - c[i - 1])
    }
    max /= 2
    max = Math.max(max, c[0])
    max = Math.max(max, n - 1 - c[c.size - 1])
    return max
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nm = scan.nextLine().split(" ")

    val n = nm[0].trim().toInt()

    val m = nm[1].trim().toInt()

    val c = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = flatlandSpaceStations(n, c)

    println(result)
}
