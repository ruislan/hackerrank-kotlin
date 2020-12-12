package practice.algorithms.strings.easy

import java.util.*

// Complete the camelcase function below.
fun camelcase(s: String): Int {
    // 方法1
    // 检查单个字符是否是大写字母，如果是就是新的单词
    // 第一个单词是小写，所以一开始就是1
    // Passed
    var answer = 1
    for (x in s) {
        if (x in 'A'..'Z') {
            answer += 1
        }
    }
    return answer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = camelcase(s)

    println(result)
}
