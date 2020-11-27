package practice.algorithms.implementation.easy

import java.util.*

// Complete the acmTeam function below.
fun acmTeam(topic: Array<String>): Array<Int> {
    // 方法1
    // 暴力法
    // topic的全组合遍历，然后算出他们覆盖的科目数（有1个为1的）
    // Passed 时间O（n^2)
    val answer = Array(2) { 0 }
    for (i in 0 until topic.size) {
        for (j in i + 1 until topic.size) {
            val n1 = topic[i]
            val n2 = topic[j]
            var subjects = 0
            for (k in 0 until n1.length) {
                if (n1[k] == '1' || n2[k] == '1') {
                    subjects += 1
                }
            }
            if (subjects == answer[0]) {
                answer[1] += 1
            } else if (subjects > answer[0]) {
                answer[0] = subjects
                answer[1] = 1
            }
        }
    }
    return answer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nm = scan.nextLine().split(" ")

    val n = nm[0].trim().toInt()

    val m = nm[1].trim().toInt()

    val topic = Array<String>(n, { "" })
    for (i in 0 until n) {
        val topicItem = scan.nextLine()
        topic[i] = topicItem
    }

    val result = acmTeam(topic)

    println(result.joinToString("\n"))
}
