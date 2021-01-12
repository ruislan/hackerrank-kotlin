package practice.algorithms.search.easy

import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val n = scan.nextLine().trim().toInt()
    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    val m = scan.nextLine().trim().toInt()
    val brr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    // 方法1
    // 利用hashmap大法解决
    // 其他就是注意审题
    // Passed
    val hashmap = HashMap<Int, Int>()
    for (x in arr) {
        var freq = hashmap[x]
        if (freq == null) freq = 0
        hashmap[x] = freq + 1
    }

    val missing = HashSet<Int>()
    for (x in brr) {
        val freq = hashmap[x]
        if (freq == null || freq == 0) missing.add(x)
        else hashmap[x] = freq - 1
    }

    val answer = missing.toTypedArray()
    answer.sort()
    println(answer.joinToString(" "))
}
