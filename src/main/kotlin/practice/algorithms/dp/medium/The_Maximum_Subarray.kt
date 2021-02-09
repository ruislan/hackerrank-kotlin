package practice.algorithms.dp.medium

import kotlin.math.max

// 方法1
// 这道题是经典的动态规划
// 求最长子数组的和
// 我们用maxSubArr来记录这个全局最大
// 用sum来记录局部最大
// 状态转移就是sum + 当前数字和当前数字中的最大值
// 因为如果当前数字比sum大了，那么自然我们可以丢弃之前的sum，只要当前数字了
// AC
fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()
    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()
        val arr = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
        val po = arr.filter { it >= 0 }.toTypedArray()
        if (po.isEmpty()) {
            val max = arr.maxOrNull()
            println("$max $max")
        } else {
            var maxSubArr = 0
            var sum = 0
            for (i in 0 until n) {
                sum = max(arr[i], sum + arr[i])
                maxSubArr = max(maxSubArr, sum)
            }

            println("$maxSubArr ${po.sum()}")
        }
    }
}
