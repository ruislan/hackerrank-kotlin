package practice.algorithms.implementation.easy

import java.util.*

fun solution(B: Array<Int>) {
    // 方法1
    // 找出所有的奇数所在的位置
    // 然后判断奇数的个数，
    // 如果是奇数个：
    //   因为是成对转换的关系，所以奇数个奇数无法转换成偶数
    // 如果是偶数个：
    //   那么两两奇数配对，后一个奇数减去前一个奇数就是需要转换的次数，次数乘以2即是结果
    // Passed
    val odds = mutableListOf<Int>()
    for (i in B.indices) {
        if (B[i] and 1 == 1) {
            odds.add(i)
        }
    }
    if (odds.size and 1 == 1) {
        println("NO")
    } else {
        var answer = 0
        for (i in odds.indices step 2) {
            answer += (odds[i + 1] - odds[i])
        }
        println(answer shl 1)
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val N = scan.nextLine().trim().toInt()
    val B = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    solution(B)
}