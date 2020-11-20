package practice.algorithms.implementation.easy

import java.util.*

// Complete the findDigits function below.
fun findDigits(n: Int): Int {
    // 方法1
    // 将n的每位数字提取出来x：
    //    如果x != 0 && n % x == 0： 计数加一
    // 返回计数
    // Passed
    var count = 0
    var digit = n
    while (digit > 0) {
        val x = digit % 10
        if (x != 0 && n % x == 0) count += 1
        digit /= 10
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val result = findDigits(n)

        println(result)
    }
}
