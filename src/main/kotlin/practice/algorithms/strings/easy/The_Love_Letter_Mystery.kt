package practice.algorithms.strings.easy

import java.util.*

// Complete the theLoveLetterMystery function below.
fun theLoveLetterMystery(s: String): Int {
    // 方法1
    // 回文的关键就是左右相等
    // 所以双指针，如果两个不相等，则就是要调整
    // 调整的次数就是两个字符的差值，调整左边右边都是OK的
    // Passed
//    var lo = 0
//    var hi = s.length - 1
//    var answer = 0
//    while (lo < hi) {
//        answer += Math.abs(s[hi] - s[lo])
//        lo += 1
//        hi -= 1
//    }
//    return answer

    // 方法2
    // 不用两个指针，动态计算也可以
    // Passed
    val n = s.length
    var answer = 0
    for (i in 0..(n - 1) / 2) {
        answer += Math.abs(s[i] - s[n - 1 - i])
    }
    return answer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = theLoveLetterMystery(s)

        println(result)
    }
}
