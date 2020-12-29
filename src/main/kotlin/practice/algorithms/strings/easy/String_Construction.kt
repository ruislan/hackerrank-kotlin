package practice.algorithms.strings.easy

import java.util.*

// Complete the stringConstruction function below.
fun stringConstruction(s: String): Int {
    // 方法1
    // 直接统计之前没有出现过的字符就行了
    // Passed
    val sets = HashSet<Char>()
    var answer = 0
    for (x in s) {
        if (sets.add(x)) {
            answer += 1
        }
    }
    return answer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = stringConstruction(s)

        println(result)
    }
}
