package practice.algorithms.strings.easy

import java.util.*
import kotlin.collections.HashSet

// Complete the gemstones function below.
fun gemstones(arr: Array<String>): Int {
    // 方法1
    // 简单来说就是所有的arr[i]的交集
    // 用hashset记录第一个字符串的所有字符
    // 然后后面的字符串如果在第一个中出现的就留下，其他的删除
    // Passed
    var set = HashSet<Char>()
    val n = arr.size;
    for (x in arr[0]) {
        set.add(x)
    }

    for (i in 1 until n) {
        val newSet = HashSet<Char>()
        for (x in arr[i]) {
            if (set.contains(x)) {
                newSet.add(x)
            }
        }
        set = newSet
    }

    return set.size
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = Array<String>(n, { "" })
    for (i in 0 until n) {
        val arrItem = scan.nextLine()
        arr[i] = arrItem
    }

    val result = gemstones(arr)

    println(result)
}
