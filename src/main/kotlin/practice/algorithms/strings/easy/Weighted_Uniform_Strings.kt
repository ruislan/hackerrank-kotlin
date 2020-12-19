package practice.algorithms.strings.easy

import java.util.*
import kotlin.collections.HashSet

// Complete the weightedUniformStrings function below.
fun weightedUniformStrings(s: String, queries: Array<Int>): Array<String> {
    // 方法1
    // 将所有符合uniform的string都存入hashmap中
    // 注意像aaa这样的实际有3个，分别是a, aa和aaa
    // 迭代queries，如果在map中存在，就取出来
    // Passed
    val sets = HashSet<Int>()
    var prev = s[0]
    var weight = prev - 'a' + 1
    sets.add(weight)
    for (i in 1 until s.length) {
        if (s[i] != prev) {
            prev = s[i]
            weight = 0
        }
        weight += prev - 'a' + 1
        sets.add(weight)
    }
    if (weight > 0) sets.add(weight)
    return queries.map { if (sets.contains(it)) "Yes" else "No" }.toTypedArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val queriesCount = scan.nextLine().trim().toInt()

    val queries = Array<Int>(queriesCount, { 0 })
    for (i in 0 until queriesCount) {
        val queriesItem = scan.nextLine().trim().toInt()
        queries[i] = queriesItem
    }

    val result = weightedUniformStrings(s, queries)

    println(result.joinToString("\n"))
}
