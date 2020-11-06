package practice.algorithms.implementation

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
    val x = if (n and 1 == 0) n + 1 else n
    return if (p <= (x shr 1)) p shr 1 else (x - p) shr 1
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val p = scan.nextLine().trim().toInt()

    val result = pageCount(n, p)

    println(result)
}
