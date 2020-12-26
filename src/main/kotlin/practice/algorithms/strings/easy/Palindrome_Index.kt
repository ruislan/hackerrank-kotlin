package practice.algorithms.strings.easy

import java.util.*

// Complete the palindromeIndex function below.
fun palindromeIndex(s: String): Int {
    // 方法1
    // 逐个字母删除，然后看是不是回文
    // 由于本题s的长度较大，肯定会超时
    // 就不予考虑这种方法

    // 方法2
    // 在出现第一个字符不相等的情况下，分成两边去检查，
    // 一边是删掉左边的字符，一边是删掉右边的字符
    // 因为答案一定存在，所以这两个选项中一定有一个是正确的
    // Passed
    var lo = 0
    var hi = s.length - 1
    while (lo < hi) {
        if (s[lo] != s[hi]) break
        lo += 1
        hi -= 1
    }

    if (lo >= hi) return -1

    val i = lo
    val j = hi
    lo += 1
    while (lo < hi) {
        if (s[lo] != s[hi]) return j
        lo += 1
        hi -= 1
    }
    return i
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = palindromeIndex(s)

        println(result)
    }
}
