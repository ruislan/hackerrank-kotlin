package practice.algorithms.strings.easy

import java.util.*

// Complete the minimumNumber function below.
fun minimumNumber(n: Int, password: String): Int {
    // 方法1
    // 设置4个bool分别表示是否有数字，是否有大写字符，是否有小写字符，是否有特殊字符
    // 然后迭代字符串，根据字符的情况设置这4个bool
    // 最后检查一下如果加上这些字符是否达到了最低的长度要求6，
    // 没有就再加上缺少的数量
    // 时间是O(n * 26)
    // Passed
    var hasDigit = false
    var hasLowerCase = false
    var hasUpperCase = false
    var hasSpecialCharacters = false
    for (ch in password) {
        if (!hasDigit && ch.isDigit()) hasDigit = true
        if (!hasLowerCase && ch.isLowerCase()) hasLowerCase = true
        if (!hasUpperCase && ch.isUpperCase()) hasUpperCase = true
        if (!hasSpecialCharacters && ch in "!@#$%^&*()-+") hasSpecialCharacters = true
    }
    var answer = 0
    if (!hasDigit) answer += 1
    if (!hasLowerCase) answer += 1
    if (!hasUpperCase) answer += 1
    if (!hasSpecialCharacters) answer += 1
    if (n + answer < 6) answer += 6 - (n + answer)
    return answer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val password = scan.nextLine()

    val answer = minimumNumber(n, password)

    println(answer)
}
