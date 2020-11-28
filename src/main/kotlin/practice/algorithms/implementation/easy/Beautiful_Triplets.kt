package practice.algorithms.implementation.easy

import java.util.*
import kotlin.collections.*

// Complete the beautifulTriplets function below.
fun beautifulTriplets(d: Int, arr: Array<Int>): Int {
    // 方法1
    // 将arr的数字频率放入hashmap中
    // 迭代hashmap中的每个数字：
    //     如果map.contains(数字+d)和map.contains(数字+ 2 * d)：
    //         则说明这三个数字符合条件，然后结果加上他们各自的频率乘积
    // 返回结果
    // Passed
    val freq = HashMap<Int, Int>()
    for (x in arr) {
        if (freq[x] == null) freq[x] = 0
        freq[x] = freq[x]!! + 1
    }
    var answer = 0
    for (kv in freq) {
        if (freq[kv.key + d] != null && freq[kv.key + 2 * d] != null) {
            answer += kv.value * freq[kv.key + d]!! * freq[kv.key + 2 * d]!!
        }
    }
    return answer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()

    val d = nd[1].trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = beautifulTriplets(d, arr)

    println(result)
}
