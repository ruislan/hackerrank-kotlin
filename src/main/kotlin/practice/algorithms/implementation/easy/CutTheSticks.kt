package practice.algorithms.implementation.easy

import java.util.*

// Complete the cutTheSticks function below.
fun cutTheSticks(arr: Array<Int>): Array<Int> {
    // 方法1
    // 每次选出最小的那个，然后让arr[i]减去min，过滤掉等于0的
    // 直到所有的arr都没有
    val answer = mutableListOf<Int>()
    var nums = arr
    while (nums.isNotEmpty()) {
        answer.add(nums.size)
        val min = nums.minOrNull() ?: 0
        nums = nums.map { it - min }.filter { it != 0 }.toTypedArray()
    }
    return answer.toTypedArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = cutTheSticks(arr)

    println(result.joinToString("\n"))
}
