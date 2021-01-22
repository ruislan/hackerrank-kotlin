package practice.algorithms.greedy.easy

fun main(args: Array<String>) {
    val nk = readLine()!!.split(" ")
    val n = nk[0].trim().toInt()
    val k = nk[1].trim().toLong()
    // 方法1
    // 有点经典背包的意思了
    // 固定钱买到更多的东西
    // 排序东西的价格，尽量挑选价值小的
    // 这样能保证最多的toys
    // 值得注意的是，prices[i]相加会出现溢出的问题
    // Passed
    val prices = readLine()!!.split(" ").map { it.trim().toLong() }.toTypedArray()
    prices.sort()
    var amount = 0L
    var toys = 0
    for (i in prices.indices) {
        amount += prices[i]
        if (amount <= k) toys += 1
    }
    println(toys)
}
