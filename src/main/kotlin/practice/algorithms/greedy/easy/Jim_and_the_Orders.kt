package practice.algorithms.greedy.easy

fun main() {
    // 方法1
    // 送餐顺序基于点餐时间和制作时长
    // 那么只需要将点餐时间+制作时长来排序即可
    // 细节上就是将读入的顺序作为第三个参数加入到集合中
    // 这样排序后可以直接输出第三个参数
    // Passed
    val n = readLine()!!.trim().toInt()
    val orders = Array(n) { ArrayList<Int>() }
    for (i in 0 until n) {
        readLine()!!.split(" ").forEach {
            orders[i].add(it.trim().toInt())
        }
        orders[i].add(i)
    }
    orders.sortBy { it[0] + it[1] }
    println(orders.map { it[2] + 1 }.joinToString(" "))
}
