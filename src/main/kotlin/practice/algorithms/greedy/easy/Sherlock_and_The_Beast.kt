package practice.algorithms.greedy.easy

fun decentNumber(n: Int): String {
    // 方法1
    // 我们先检查是否能够被3整除
    // 不行的话就减去5个数看是否能被3整除
    // 不行的话再减，直到留下的n不够三个数了
    // 当剩下的数字能够被3整除的话，我们就迭代多少个“555”，
    // 然后统计我们减去了多少个5，就是加上多少个“33333”
    // 如果到n不够三个数字了
    // 那么就返回-1，说明无法组成这样的数字
    // Passed
    var cnt = 0
    var remain: Int
    while (true) {
        remain = n - cnt * 5
        if (remain % 3 == 0) return "555".repeat(remain / 3) + "33333".repeat(cnt)
        if (remain < 3) break
        cnt += 1
    }
    return "-1"
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()
    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()
        println(decentNumber(n))
    }
}
