package practice.algorithms.implementation.easy

import java.util.*

// Complete the kaprekarNumbers function below.
fun kaprekarNumbers(p: Int, q: Int): Unit {
    // 方法1
    // 注意平方可能会超出Int上界，所以转成long
    // 计算出需要断开的地方，转换成string在断点处分成两份之后再转回Int
    // 看相加后是否是原数字，是的话放入结果集
    // 没有结果就打印INVALID RANGE，有就打印结果
    // Passed
    val nums = mutableListOf<Int>()
    (p..q).forEach {
        val r = it.toString().length
        val x = (it.toLong() * it.toLong()).toString()
        val splitAt = x.length - r
        val y = if (x.length > r) x.substring(0, splitAt).toInt() + x.substring(splitAt).toInt() else x.toInt()
        if (y == it) nums.add(y)
    }
    print(if (nums.isEmpty()) "INVALID RANGE" else nums.joinToString(" "))
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val p = scan.nextLine().trim().toInt()

    val q = scan.nextLine().trim().toInt()

    kaprekarNumbers(p, q)
}
