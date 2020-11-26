package practice.algorithms.implementation.easy

import java.util.*

// Complete the jumpingOnClouds function below.
fun jumpingOnClouds(c: Array<Int>): Int {
    // 方法1
    // 将云分成3段
    // 起跳，中间和结尾
    // 起跳少算1个雷云，结尾少算一个雷云
    // 中间看有多少个空位，然后除以2就能得到最短跳次数
    // 全部加起来就是结果
    // Passed
//    var last = -1
//    var answer = 0
//    for (i in c.indices) {
//        if (c[i] == 1) {
//            answer += 1 + if (last == -1) i / 2 else (i - last - 1) / 2
//            last = i
//        }
//    }
//    return answer + ((c.size - 1 - last) / 2)

    // 方法2
    // 模拟
    // 看是否能跳两格，不能跳两格，就跳一格，能跳两格就跳两格
    var i = 0
    var answer = 0
    while (i < c.size - 1) {
        if (i + 2 >= c.size || c[i + 2] == 1) {
            i += 1
            answer += 1
        } else {
            i += 2
            answer += 1
        }
    }
    return answer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val c = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = jumpingOnClouds(c)

    println(result)
}
