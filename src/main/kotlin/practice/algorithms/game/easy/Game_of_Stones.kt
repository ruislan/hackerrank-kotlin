package practice.algorithms.game.easy

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()
    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()
        // 方法1
        // 用bool数组来表示p1还是p2获胜，true = p1
        // 获胜的关键就是要将输的那个数字留给对方
        // 目前已知输的数字是0（p1没得拿了），那么赢的数字就是
        // 0+2 = 2,0+3 = 3,0+5 = 5
        // 也就是1会输，重复上述步骤得到
        // 1+2 = 3,1+3 = 4,1+5 = 6
        // 也就是7会输，那么再用会输的数字重复上述直到n
        // 这样我们就知道第n个数字到底谁赢了
        // AC
        val stones = BooleanArray(n + 1)
        var i = 0
        while (i <= n) {
            if (!stones[i] && i + 2 <= n) stones[i + 2] = true
            if (!stones[i] && i + 3 <= n) stones[i + 3] = true
            if (!stones[i] && i + 5 <= n) stones[i + 5] = true
            i += 1
        }
        println(if (stones[n]) "First" else "Second")
    }
}
