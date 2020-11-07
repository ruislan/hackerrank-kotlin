package practice.algorithms.implementation.easy

import java.util.*

/*
 * Complete the pageCount function below.
 */
fun pageCount(n: Int, p: Int): Int {
    // 方法1
    // 先找到中间页的位置mid
    // 如果p > mid：
    //    需要从后向前翻动，(n - p) / 2
    // 否则：
    //    需要从前向后翻动， p / 2
    val mid = n + ((n and 1) xor 1)
    return if (p <= (mid shr 1)) p shr 1 else (mid - p) shr 1
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val p = scan.nextLine().trim().toInt()

    val result = pageCount(n, p)

    println(result)
}
