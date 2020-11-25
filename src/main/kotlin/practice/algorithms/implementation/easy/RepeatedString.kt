package practice.algorithms.implementation.easy

import java.util.*

// Complete the repeatedString function below.
fun repeatedString(s: String, n: Long): Long {
    // 方法1
    // 首先看n是s.len()的多少倍，这样能统计出a的整体倍数
    // 然后求出n与s.len()的余数，这样便于统计剩下的a
    // Passed
//    val tail = (n % s.length).toInt()
//    val times = n / s.length
//    var answer = s.filter { it == 'a' }.count().toLong() * times
//    answer += (0 until tail).filter { s[it] == 'a' }.count()
//    return answer
    // 也可以精简成一行，不过没啥意义
    return s.filter { it == 'a' }.count() * (n / s.length) + (0 until n % s.length).filter { s[it.toInt()] == 'a' }.count()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val n = scan.nextLine().trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}
