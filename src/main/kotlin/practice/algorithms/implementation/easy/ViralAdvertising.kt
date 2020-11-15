package practice.algorithms.implementation.easy

import java.util.*

// Complete the viralAdvertising function below.
fun viralAdvertising(n: Int): Int {
    // 方法1
    // 直接根据描述可以设立三个参数shared，liked和cumulative
    // 通过观察题目表格可以知道：
    //    当日shared = 昨日liked * 3
    //    当日liked = 当日shared / 2
    //    当日cumulative = 昨日cumulative + 当日liked
    // 而我们可以省略这个公式的shared，只需要liked和cumulative即可
    // Passed
    var liked = 2
    var cumulative = 2
    (2..n).forEach {
        liked = (liked * 3) shr 1
        cumulative += liked
    }
    return cumulative
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val result = viralAdvertising(n)

    println(result)
}
