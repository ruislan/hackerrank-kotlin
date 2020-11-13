package practice.algorithms.implementation.easy

import java.util.*

// Complete the utopianTree function below.
fun utopianTree(n: Int): Int {
    // 方法1
    // 模拟过程即可
    // Passed
//    var answer = 1
//    for (i in 1..n)
//        if (i and 1 == 1) answer *= 2
//        else answer += 1
//    return answer

    // 方法2
    // 根据数列总结出公式
    // 2^(((n + (n%2))/2 + 1) - (1 + n%2)
    // Passed
    return (Math.pow(2.0, (((n + (n % 2)) / 2) + 1).toDouble()) - (1 + n % 2)).toInt()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val result = utopianTree(n)

        println(result)
    }
}
