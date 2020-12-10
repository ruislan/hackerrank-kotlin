package practice.algorithms.implementation.easy

import java.util.*

// Complete the strangeCounter function below.
fun strangeCounter(t: Long): Long {
    // 方法1
    // 这个表格的特点就是下一个区域的第一个数字元组的左边就是time + value，右边就是value * 2
    // 所以思路就是先判断t落在哪个区域里面，
    // 然后求出t与time的差值就是偏移量，然后用value减去偏移量就是结果
    // Passed 时间是O(logN)，因为我们在每次两倍的逼近t嘛
    var time = 1L
    var value = 3L
    while (t >= time + value) {
        time += value
        value = value shl 1
    }
    return value - (t - time)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toLong()

    val result = strangeCounter(t)

    println(result)
}
