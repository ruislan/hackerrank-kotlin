package practice.algorithms.implementation.easy

import java.util.*

// Complete the serviceLane function below.
fun serviceLane(width: Array<Int>, cases: Array<Array<Int>>): Array<Int> {
    // 方法1
    // 这道题题目的方法传入的是n，修改一下是width，没有width我们怎么搞？
    // 找出每个范围内最小的那个数字就行了
    // Passed O(n^2)
    val answer = Array(cases.size) { 0 }
    for (i in cases.indices) {
        var min = Int.MAX_VALUE
        for (j in cases[i][0]..cases[i][1]) {
            min = Math.min(min, width[j])
        }
        answer[i] = min
    }
    return answer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nt = scan.nextLine().split(" ")

    val n = nt[0].trim().toInt()

    val t = nt[1].trim().toInt()

    val width = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val cases = Array<Array<Int>>(t, { Array<Int>(2, { 0 }) })

    for (i in 0 until t) {
        cases[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = serviceLane(width, cases)

    println(result.joinToString("\n"))
}
