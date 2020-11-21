package practice.algorithms.implementation.easy

import java.util.*
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

// Complete the squares function below.
fun squares(a: Int, b: Int): Int {
    // 方法1
    // 从1到b/2,求平方，看是否为在a,b范围内
    // timeout O(n^2)
    // return (1..(b/2)).filter { it * it in (a..b)}.count()

    // 方法2
    // 二分查找法
    // 依然超时 O(nlogn)
    //    return (a..b).filter {
    //        var lo = 1
    //        var hi = it shr 1
    //        while (lo <= hi) {
    //            val mid = lo + ((hi - lo) shr 1)
    //            val cmp = (mid * mid).compareTo(it)
    //            if (cmp == 0) {
    //                lo = mid
    //                break
    //            }
    //            if (cmp == 1) hi = mid - 1
    //            else lo = mid + 1
    //        }
    //        lo * lo == it
    //    }.count()

    // 方法3
    // 方法1的优化，方法1算到了b/2，其实我们只要sqrt(b)就够了
    // Passed time: O(sqrt(b))
    // return (1..Math.sqrt(b.toDouble()).toInt()).filter { it * it in (a..b)}.count()

    // 方法4
    // 方法3的优化
    // 方法3还考虑了从1开始，其实我们只需要考虑sqrt(a)和sqrt(b)之间
    // sqrt(a)向上取整，因为结果必须要大于或等于sqrt(a)
    // sqrt(b)向下取整，因为结果必须要小于或等于sqrt(b)
    // 因为是统计个数，所以两个相减之后的值还要+1
    // Passed time O(1)
    return (floor(sqrt(b.toDouble())) - ceil(sqrt(a.toDouble()))).toInt() + 1
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val ab = scan.nextLine().split(" ")

        val a = ab[0].trim().toInt()

        val b = ab[1].trim().toInt()

        val result = squares(a, b)

        println(result)
    }
}
