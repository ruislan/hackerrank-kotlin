package practice.algorithms.implementation.easy

import java.util.*

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {
    // 方法1
    // 利用hashmap存储同种颜色的🧦的数量
    // 迭代hashmap，将每个数量 / 2 并求和
    // 这个和就是最终结果
    return ar.groupingBy { it }.eachCount().map { it.value / 2 }.sum()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}
