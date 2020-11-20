package practice.algorithms.implementation.easy

import java.util.*

// Complete the appendAndDelete function below.
fun appendAndDelete(s: String, t: String, k: Int): String {
    // 方法1
    // 首先如果k比s+t都长，那说明怎么操作都OK
    // 然后找出s与t的前缀相等长度pre_equals
    // 接着求出两边相异的部分diff = len(s) + len(t) - preEquals
    // 如果diff <= k，那就有可能可以处理，我们还需要检查(k - diff) % 2 == 0
    // 因为解决掉diff之后，其他操作都是多余的
    // 而多余的操作我们需要成对出现，delete和append，只有delete或者append是不行的
    if (k >= s.length + t.length) return "Yes"
    var preEquals = 0
    for (i in 0 until Math.min(s.length, t.length)) {
        if (s[i] != t[i]) break
        preEquals += 2
    }
    val diff = s.length + t.length - preEquals
    return if (diff <= k && (k - diff) and 1 == 0) "Yes" else "No"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val t = scan.nextLine()

    val k = scan.nextLine().trim().toInt()

    val result = appendAndDelete(s, t, k)

    println(result)
}
