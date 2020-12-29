package practice.algorithms.strings.easy

import java.util.*

// Complete the makingAnagrams function below.
fun makingAnagrams(s1: String, s2: String): Int {
    // 方法1
    // 统计两个字符串的频率，找出两个频率之间的差值统计即可
    // Passed
    val m1 = IntArray(26)
    val m2 = IntArray(26)
    for (x in s1) m1[x.toInt() - 97] += 1
    for (x in s2) m2[x.toInt() - 97] += 1
    return m1.zip(m2).map { Math.abs(it.first - it.second) }.sum()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s1 = scan.nextLine()

    val s2 = scan.nextLine()

    val result = makingAnagrams(s1, s2)

    println(result)
}
