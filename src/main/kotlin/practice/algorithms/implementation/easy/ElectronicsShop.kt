package practice.algorithms.implementation.easy

import java.util.*

/*
 * Complete the getMoneySpent function below.
 */
fun getMoneySpent(keyboards: Array<Int>, drives: Array<Int>, b: Int): Int {
    // 方法1
    // O(n^2)解法
    // 迭代keyboards：
    //    迭代drivers：
    //       如果k[i] + d[j] > answer 且 <= b
    //          设置answer = k[i] + d[j]
    // 返回answer
    // Passed
    var answer = -1
    for (keyboard in keyboards) {
        for (drive in drives) {
            val sum = keyboard + drive
            if (sum <= b) {
                answer = Math.max(sum, answer)
            }
        }
    }
    return answer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val bnm = scan.nextLine().split(" ")

    val b = bnm[0].trim().toInt()

    val n = bnm[1].trim().toInt()

    val m = bnm[2].trim().toInt()

    val keyboards = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val drives = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    /*
     * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
     */

    val moneySpent = getMoneySpent(keyboards, drives, b)

    println(moneySpent)
}
