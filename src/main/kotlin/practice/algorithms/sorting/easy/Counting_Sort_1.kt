package practice.algorithms.sorting.easy

import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val n = scan.nextLine().trim().toInt()
    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    // 方法1
    // 没啥好说的，跟着描述做就行了
    // Passed
    val answer = IntArray(100)
    for (x in arr) {
        answer[x] += 1
    }

    println(answer.joinToString(" "))
}
