package practice.algorithms.greedy.medium

// 方法1
// 首先要搞清楚所有的花都要被买走
// 所以只要k >= n，那么肯定最小的价格就是一人买一束花
// 而k < n的时候，就会出现有人第二次购买的情况，
// 由于题目告诉你每个人多一次购买，价格强制翻倍，也就是说
// 第二次购买的东西价格会翻原价一倍，三次翻原价两倍，以此类推
// 所以为了保证最低购买，我们必须让第二次购买的人买的原价尽量低才能保证最小
// 也就是说我们从价格最大到最小的开始买，这样大的价格翻倍系数就最低
// 小的价格虽然翻倍系数高，但是由于其价格小，所以影响也是最低
// 其实这题的贪心思想我想很多人买东西都会算，所以不算难
// AC 12/12
fun getMinimumCost(k: Int, c: Array<Int>): Int {
    c.sortDescending()
    var factor = 0
    var answer = 0
    for (i in c.indices) {
        if (i % k == 0) factor += 1
        answer += c[i] * factor
    }
    return answer
}

fun main(args: Array<String>) {
    val nk = readLine()!!.split(" ")
    val n = nk[0].trim().toInt()
    val k = nk[1].trim().toInt()
    val c = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
    val minimumCost = getMinimumCost(k, c)
    println(minimumCost)
}
