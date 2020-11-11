package practice.algorithms.implementation.easy

import java.util.*

// Complete the hurdleRace function below.
fun hurdleRace(k: Int, height: Array<Int>): Int {
    // 方法1
    // 迭代height找到最高点highest，
    // 最高点如果大于k，返回 highest - k
    // 否则返回0
    // Passed
    val answer = height.max()!! - k
    return if (answer > 0) answer else 0
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val height = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = hurdleRace(k, height)

    println(result)
}
