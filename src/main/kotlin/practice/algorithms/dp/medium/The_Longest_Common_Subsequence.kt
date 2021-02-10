package practice.algorithms.dp.medium

import kotlin.math.max

// 方法1
// 本题考察了两个点
// 第一个是最长公共子序列，这个是经典的DP案例了（注意和最长公共子串的区别）
// 第二个就是要将这个字串打印出来
// 重点说第二个
// 第二个的方法是从dp最后一个开始看，当dp[i][j]是0时退出循环（其中一个列表已经到达起点）：
//    如果a和b对应位置的数字也相同且它的左边和上边相同，且，那么说明这个是公共的，
//    存储这个数字，同时i-1，j-1，也就是向左斜上移动，继续循环。
//    如果a和b对应位置的数字不相同，则左边和上边谁大就向谁移动，
//    如果相同则随便移动一边，我这里是向左移动
// 最后由于我们是从后向前，所以最后还需要翻转一下
// AC
fun main(args: Array<String>) {
    val nm = readLine()!!.split(" ")
    val n = nm[0].trim().toInt()
    val m = nm[1].trim().toInt()
    val a = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
    val b = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
    val dp = Array(n + 1) { Array(m + 1) { 0 } }
    for (i in 1..n) {
        for (j in 1..m) {
            if (a[i - 1] == b[j - 1]) {
                dp[i][j] = 1 + dp[i - 1][j - 1]
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    val answer = mutableListOf<Int>()
    var i = n
    var j = m
    while (dp[i][j] > 0) {
        if (dp[i - 1][j] == dp[i][j - 1] && a[i - 1] == b[j - 1]) {
            answer.add(a[i - 1])
            i -= 1
            j -= 1
            continue
        }
        if (dp[i - 1][j] > dp[i][j - 1]) {
            i -= 1
        } else {
            j -= 1

        }
    }
    answer.reverse()
    println(answer.joinToString(" "))
}
