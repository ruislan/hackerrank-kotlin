package practice.algorithms.implementation.easy

import java.util.*
import kotlin.collections.HashMap

// Complete the permutationEquation function below.
fun permutationEquation(p: Array<Int>): Array<Int> {
    // 方法1
    // 先将全部的p[i]和它的索引存入map
    // 然后迭代x in 1..p.size
    // 对于每个x ，从map中找到其索引i，然后找出从map中再找出索引i + 1的索引j
    // 存储j + 1
    // Passed
    val map = HashMap<Int, Int>()
    val answer = Array(p.size) { 0 }
    for (i in p.indices) map[p[i]] = i
    for (x in 1..p.size) answer[x - 1] = map[map[x]!! + 1]!! + 1
    return answer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val p = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = permutationEquation(p)

    println(result.joinToString("\n"))
}
