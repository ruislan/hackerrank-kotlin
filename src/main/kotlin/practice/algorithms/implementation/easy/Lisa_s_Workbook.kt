package practice.algorithms.implementation.easy

import java.util.*

// Complete the workbook function below.
fun workbook(n: Int, k: Int, arr: Array<Int>): Int {
    // 方法1
    // 迭代arr取出每组problems的数量
    // 从1到problems迭代：
    //    如果页数与problem编号相等，结果+1
    //    如果problem编号正好是页数的整数倍或者problem已经是最后一个，翻页
    // 返回结果
    // Passed
    var page = 1
    var answer = 0
    for (problems in arr) {
        for (p in 1..problems) {
            if (page == p) answer += 1
            if (p % k == 0 || p == problems) page += 1
        }
    }
    return answer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = workbook(n, k, arr)

    println(result)
}
