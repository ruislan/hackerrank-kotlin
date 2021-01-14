package practice.algorithms.greedy.easy

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()
    val calorie = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
    // 方法1
    // 简单的贪心算法
    // 最大的值乘以最小的系数，这样就能保证最后的总和最小
    // Passed
    calorie.sortDescending()
    var factor = 1L
    var sum = 0L
    for (c in calorie) {
        sum += c * factor
        factor = factor shl 1
    }
    println(sum)
}
