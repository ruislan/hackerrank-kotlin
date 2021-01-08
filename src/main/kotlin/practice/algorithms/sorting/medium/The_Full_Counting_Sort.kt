package practice.algorithms.sorting.medium

import java.util.*
import kotlin.math.max

fun main(args: Array<String>) {
    // 方法1
    // 只需要注意一点，就是创建的answer数组的长度应该是x[i]中最大的那个+1
    // Passed
    val n = readLine()!!.trim().toInt()
    val arr = mutableListOf<Pair<Int, String>>()
    var size = 0
    for (i in 0 until n) {
        val xs = readLine()!!.trimEnd().split(" ").toTypedArray()
        val x = xs[0].toInt()
        val s = xs[1]
        arr.add(Pair(x, s))
        size = max(x, size)
    }

    val answer = Array(size + 1) { ArrayList<String>() }
    val half = n shr 1
    for (i in 0 until n) {
        val j = arr[i].first
        if (i < half) {
            answer[j].add("-")
        } else {
            answer[j].add(arr[i].second)
        }
    }

    val sb = StringBuilder()
    for (i in answer.indices) {
        if (answer[i].isNotEmpty()) {
            sb.append(answer[i].joinToString(" "))
            if (i < answer.size - 1) sb.append(" ")
        }
    }
    println(sb.toString())
}
