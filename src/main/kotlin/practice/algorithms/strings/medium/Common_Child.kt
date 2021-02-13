package practice.algorithms.strings.medium

import java.util.*

// https://www.hackerrank.com/challenges/common-child/problem

// 方法1
// 最长公共子序列
// 经典DP解决
// AC
fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val s1 = scan.nextLine()
    val s2 = scan.nextLine()

    val n = s1.length
    val m = s2.length
    val dp = Array(n + 1) { IntArray(m + 1) }
    for (i in 1..n) {
        for (j in 1..m) {
            if (s1[i - 1] == s2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = kotlin.math.max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }

    println(dp[n][m])
}
