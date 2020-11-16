package practice.algorithms.implementation.easy

import java.util.*

// Complete the saveThePrisoner function below.
fun saveThePrisoner(n: Int, m: Int, s: Int): Int {
    // 方法1
    // 因为数据不涉及到溢出
    // 如果我们将环打开这样我们就有x个1..n
    // 实际上就是从开始位置加上m个位置再减去1个位置就刚好落在x个1..n中的某个位置
    // 然后我们再利用求除以n的余数，将缩短到1..n之间
    // 这里唯一要注意的就是如果余数为0，那说明它是在n的位置，否则直接返回余数
    // Passed
    val seat = s + m - 1
    return if (seat % n == 0) n else seat % n
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val nms = scan.nextLine().split(" ")

        val n = nms[0].trim().toInt()

        val m = nms[1].trim().toInt()

        val s = nms[2].trim().toInt()

        val result = saveThePrisoner(n, m, s)

        println(result)
    }
}
