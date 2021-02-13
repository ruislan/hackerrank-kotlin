package practice.algorithms.strings.medium

// 方法1
// 最长公共子序列
// 经典DP解决
fun main(args: Array<String>) {
    val s1 = readLine()!!
    val s2 = readLine()!!
    val n = s1.length
    val m = s2.length
    val dp = Array(n + 1) { Array(m + 1) { 0 } }
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
