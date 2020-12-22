package practice.algorithms.strings.easy

import java.util.*

// Complete the alternatingCharacters function below.
fun alternatingCharacters(s: String): Int {
    // 方法1
    // 遍历字符，
    // 如果后面的那个字符和当前字符相同，则需要删除
    // 如果不相同，则不需要删除，然后当前字符变成新的
    // Passed
//    var answer = 0
//    var prev = s[0]
//    for (i in 1 until s.length) {
//        if (s[i] == prev) answer += 1
//        else prev = s[i]
//    }
//    return answer

    // 方法2
    // 更简单一点，就是看连续两个字符串是否相等
    // 相等就要删除
    // Passed
    return (1 until s.length).filter { s[it] == s[it - 1] }.count()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = alternatingCharacters(s)

        println(result)
    }
}
