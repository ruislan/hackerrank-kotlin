package practice.algorithms.greedy.easy

fun main(args: Array<String>) {
    // 方法1
    // 排序每一行
    // 这样保证grid[row]是从小到大的
    // 这样一来grid[row]与grid[row-1]就能保证最小的和最小的比
    // 如果grid[row]最小的比grid[row-1]最小的小，
    // 那么无论如何都不满足条件了
    // Passed
    val t = readLine()!!.trim().toInt()
    for (tItr in 1..t) {
        val rows = readLine()!!.trim().toInt()
        val grid = ArrayList<CharArray>(rows)
        for (i in 0 until rows) {
            val col = readLine()!!.trim().toCharArray()
            col.sort()
            grid.add(col)
        }
        val cols = grid[0].size
        var answer = "YES"
        loop@ for (row in 1 until rows) {
            for (col in 0 until cols) {
                if (grid[row][col] < grid[row - 1][col]) {
                    answer = "NO"
                    break@loop
                }
            }
        }
        println(answer)
    }
}
