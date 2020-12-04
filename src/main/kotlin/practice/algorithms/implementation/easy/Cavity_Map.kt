package practice.algorithms.implementation.easy

import java.util.*

// Complete the cavityMap function below.
fun cavityMap(grid: Array<String>): Array<String> {
    // 方法1
    // 按照题目描述直接处理即可
    // Passed
    val rows = grid.size
    val cols = grid[0].length
    val answer = Array(rows) { "" }
    for (row in 0 until rows) {
        for (col in 0 until cols) {
            val point = grid[row][col]
            answer[row] = answer[row] +
                    if (row != 0 && // 不是第一行
                            row != rows - 1 && // 不是最后一行
                            col != 0 && // 不是第一列
                            col != cols - 1 && // 不是最后一列
                            point > grid[row - 1][col] && // 比上大
                            point > grid[row + 1][col] && // 比下大
                            point > grid[row][col - 1] && // 比左大
                            point > grid[row][col + 1]) // 比右大
                        'X'
                    else
                        point
        }
    }
    return answer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val grid = Array<String>(n, { "" })
    for (i in 0 until n) {
        val gridItem = scan.nextLine()
        grid[i] = gridItem
    }

    val result = cavityMap(grid)

    println(result.joinToString("\n"))
}
