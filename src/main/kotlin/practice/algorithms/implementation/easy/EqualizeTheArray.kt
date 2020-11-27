package practice.algorithms.implementation.easy

import java.util.*
import kotlin.collections.*

// Complete the equalizeArray function below.
fun equalizeArray(arr: Array<Int>): Int {
    // 方法1
    // 将数字统计到hashmap中，然后取出最大的那个同样的数字
    // 剩下的那些数字就是要干掉的
    // Passed
    val freq = HashMap<Int, Int>()
    for (n in arr) {
        if (freq[n] == null) freq[n] = 0
        freq[n] = freq[n]!! + 1
    }
    var max = 0
    for (entry in freq) {
        max = Math.max(entry.value, max)
    }
    return arr.size - max
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = equalizeArray(arr)

    println(result)
}
