package practice.algorithms.strings.easy

import java.util.*

// Complete the separateNumbers function below.
fun separateNumbers(s: String): Unit {
    // 方法1
    // 我们只需要每次取第一个数字，然后判断后面的数字是否符合要求即可
    // 这里后面的数字也很简单，就是判断字符串是否是这个数字开头即可
    // 需要注意的是，每次判断了一个数字就需要跳过这个数字的长度，
    // 也即是产生一个新的字符串子序列（删除了前面数字的）
    // 最后需要注意的就是因为有32位的一半16位数字，比较长，所以要用Long来转换
    // Passed
    val n = s.length
    var i = 1
    while (i * 2 <= n) {
        val first = s.subSequence(0, i)
        if (check(s, first)) {
            println("YES $first")
            return
        }
        i += 1
    }
    println("NO")
}

fun check(s: String, first: CharSequence): Boolean {
    var remain = s.subSequence(first.length, s.length)
    if (first.startsWith('0')) return false
    var next = first.toString().toLong() + 1
    while (remain.isNotEmpty()) {
        val nextStr = next.toString()
        if (!remain.startsWith(nextStr)) return false
        remain = remain.subSequence(nextStr.length, remain.length).toString()
        next += 1
    }
    return true
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        separateNumbers(s)
    }
}
