package practice.algorithms.strings.easy

import java.util.*

// Complete the gameOfThrones function below.
fun gameOfThrones(s: String): String {
    // 方法1
    // 统计频率，如果字符的频率是奇数的次数大于1，
    // 则说明无法组成回文
    // Passed
    val freq = IntArray(26)
    for (x in s) freq[x.toInt() - 97] += 1
    return if (freq.filter { it and 1 == 1 }.count() > 1) {
        "NO"
    } else {
        "YES"
    }

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = gameOfThrones(s)

    println(result)
}
