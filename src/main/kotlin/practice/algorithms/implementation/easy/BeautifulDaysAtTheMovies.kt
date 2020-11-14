package practice.algorithms.implementation.easy

import java.util.*

// Complete the beautifulDays function below.
fun beautifulDays(i: Int, j: Int, k: Int): Int {
    // 方法1
    // 迭代i到j，将num倒转
    // 倒转需要注意的是以0结尾的数字，倒转时高位就没了
    // Passed
    var answer = 0
    for (n in i..j) {
        var num = n
        var rev = 0

        while (num > 0) {
            rev *= 10
            rev += num % 10
            num /= 10
        }

        if (Math.abs(n - rev) % k == 0) answer += 1
    }
    return answer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val ijk = scan.nextLine().split(" ")

    val i = ijk[0].trim().toInt()

    val j = ijk[1].trim().toInt()

    val k = ijk[2].trim().toInt()

    val result = beautifulDays(i, j, k)

    println(result)
}
