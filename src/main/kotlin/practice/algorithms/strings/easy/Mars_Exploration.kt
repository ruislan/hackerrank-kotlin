package practice.algorithms.strings.easy

import java.util.*

// Complete the marsExploration function below.
fun marsExploration(s: String): Int {
    // 方法1
    // 直接检查每个字符在SOS三个字符中的位置的对比
    // 用取余即可得到SOS中的位置
    // Passed
    val e = "SOS"
    return s.indices.filter { e[it % 3] != s[it] }.count()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = marsExploration(s)

    println(result)
}
