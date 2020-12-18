package practice.algorithms.strings.easy

import java.util.*

// Complete the hackerrankInString function below.
fun hackerrankInString(s: String): String {
    // 方法1
    // 注意是子序列，而不是子串
    // 比对s与"hackerrank"
    // 如果第一个字符找到了，就比对第二个，直到所有的字符都找到，返回YES
    // 没有找到就是NO
    // Passed
    val hr = "hackerrank"
    var i = 0;
    for (x in s) {
        if (x == hr[i]) {
            i += 1
        }
        if (i == hr.length) {
            break
        }
    }
    return if (i == hr.length) "YES" else "NO"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = hackerrankInString(s)

        println(result)
    }
}
