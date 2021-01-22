package practice.algorithms.greedy.easy

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()
    val w = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
    // 方法1
    // 找出当前小于等于w[i] + 4的数字，它们只需要支付一次
    // Passed
    w.sort()
    var answer = 0
    var limit = -1
    for (i in w.indices) {
        if (w[i] > limit) {
            answer += 1
            limit = w[i] + 4
        }
    }
    println(answer)
}
