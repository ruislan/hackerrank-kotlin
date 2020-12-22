package practice.algorithms.strings.easy

import java.util.*

// Complete the funnyString function below.
fun funnyString(s: String): String {
    // 方法1
    // 将字符串的相邻的差值放入list中
    // 然后倒叙差值与list中的下一项比较
    // 如果有不同，直接返回"Not Funny"
    // 迭代结束，返回"Funny"
    // Passed
    val diff = mutableListOf<Int>()
    for (i in 1 until s.length) {
        diff.add(Math.abs(s[i] - s[i - 1]))
    }
    val iter = diff.iterator()
    for (i in s.length - 2 downTo 0) {
        if (iter.next() != Math.abs(s[i] - s[i + 1])) {
            return "Not Funny"
        }
    }
    return "Funny"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = funnyString(s)

        println(result)
    }
}
