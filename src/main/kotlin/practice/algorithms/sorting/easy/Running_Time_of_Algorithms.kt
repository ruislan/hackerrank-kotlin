package practice.algorithms.sorting.easy

import java.util.*


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val n = scan.nextLine().trim().toInt()
    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    // 方法1
    // 在每次shift的时候添加一个统计就行了
    // Passed
    var answer = 0
    for (i in 1 until n) {
        val x = arr[i]
        var j = i
        while (j > 0 && arr[j - 1] > x) {
            arr[j] = arr[j - 1];
            j -= 1
            answer += 1
        }
        arr[j] = x
    }
    println(answer)
}
