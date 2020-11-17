package practice.algorithms.implementation.easy

import java.util.*

// Complete the circularArrayRotation function below.
fun circularArrayRotation(a: Array<Int>, k: Int, queries: Array<Int>): Array<Int> {
    // 方法1
    // 因为要向右移，滤掉转圈，所以需要k % a.size
    // 然后迭代queries，依次找出每个元素的位置
    // 我们实际上就是将原数组左移，那么左移转换成右移就是a.size - (k % a.size)
    // 最后，因为右移也可能出圈，我们再求余数即可
    // (a.size - (k % a.size)) % a.size
    // Passed
    val offset = k % a.size
    for (i in queries.indices) {
        queries[i] = a[(queries[i] + a.size - offset) % a.size]
    }
    return queries
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nkq = scan.nextLine().split(" ")

    val n = nkq[0].trim().toInt()

    val k = nkq[1].trim().toInt()

    val q = nkq[2].trim().toInt()

    val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val queries = Array<Int>(q, { 0 })
    for (i in 0 until q) {
        val queriesItem = scan.nextLine().trim().toInt()
        queries[i] = queriesItem
    }

    val result = circularArrayRotation(a, k, queries)

    println(result.joinToString("\n"))
}
