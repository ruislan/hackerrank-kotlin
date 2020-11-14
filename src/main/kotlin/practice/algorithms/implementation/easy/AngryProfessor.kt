package practice.algorithms.implementation.easy

import java.util.*

// Complete the angryProfessor function below.
fun angryProfessor(k: Int, a: Array<Int>): String {
    // 方法1
    // 线性扫描统计小于等于0的值是否大于等于K，输出NO，小于K，输出YES
    // Passed
    return if (a.count { it <= 0 } >= k) "NO" else "YES"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val nk = scan.nextLine().split(" ")

        val n = nk[0].trim().toInt()

        val k = nk[1].trim().toInt()

        val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

        val result = angryProfessor(k, a)

        println(result)
    }
}
