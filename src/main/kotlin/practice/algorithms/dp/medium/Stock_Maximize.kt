package practice.algorithms.dp.medium

import kotlin.math.max


fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()
        val prices = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
        // 方法1
        // 暴力，不说了，肯定超时
        //        var profit = 0L
        //        for (i in 0 until prices.size - 1) {
        //            var max = 0
        //            for (j in i + 1 until prices.size) {
        //                max = max(prices[j], max)
        //            }
        //            if (max > prices[i]) profit += max - prices[i]
        //        }
        //        println(profit)

        // 方法2
        // 倒序遍历，遇到最大就替换成新的，否则就用当前最大的
        // 这也算是DP吧？
        // AC
        var profit = 0L
        var max = 0
        for (i in n - 1 downTo 0) {
            max = max(max, prices[i])
            profit += max - prices[i]
        }
        println(profit)
    }
}
