package practice.algorithms.strings.easy

import java.util.*
import kotlin.collections.*

// Complete the twoStrings function below.
fun twoStrings(s1: String, s2: String): String {
    // 方法1
    // 直接判断s2中是否有s1的字符即可
    // 因为有共同子串的前提就是至少要有1个字符共有
    // 1个字符也是子串
    // Passed
    val sets = HashSet<Char>()
    for (x in s1) {
        sets.add(x)
    }
    for (x in s2) {
        if (sets.contains(x)) return "YES"
    }
    return "NO"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s1 = scan.nextLine()

        val s2 = scan.nextLine()

        val result = twoStrings(s1, s2)

        println(result)
    }
}
