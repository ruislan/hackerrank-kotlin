package practice.algorithms.implementation.easy

import java.util.*
import kotlin.collections.HashMap

// Complete the minimumDistances function below.
fun minimumDistances(a: Array<Int>): Int {
    // 方法1
    // 两次遍历
    // 依次算出距离，取最小的那个
    // Passed 时间O(n^2) 空间O(1)
//    val max = 100005
//    var dis = max
//    for (i in a.indices) {
//        for (j in i + 1 until a.size) {
//            if (a[i] == a[j]) {
//                dis = Math.min(dis, j - i)
//            }
//        }
//    }
//    return if (dis == max) -1 else dis

    // 方法2
    // dis放入hash表，记录最短的那个距离
    // Passed 时间O(n) 空间O(n)
    val map = HashMap<Int, Int>()
    var dis = Int.MAX_VALUE
    for (i in a.indices) {
        if (map[a[i]] != null) dis = Math.min(dis, i - map[a[i]]!!)
        map[a[i]] = i
    }
    return if (dis == Int.MAX_VALUE) -1 else dis
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = minimumDistances(a)

    println(result)
}
