package practice.algorithms.implementation.medium

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

// 方法1
// 根据题目描述编码就可以了
// 不过可以作为是否具有良好编程风格的一个考察题
// AC
fun main(args: Array<String>) {
    val s = readLine()!!

    val sqrt = sqrt(s.length.toDouble())
    var rows = floor(sqrt).toInt()
    val cols = ceil(sqrt).toInt()
    if (rows * cols < s.length) rows += 1

    val plain = s.filter { it != ' ' }.toMutableList()

    val grid = Array(rows) { Array(cols) { ' ' } }
    for (i in plain.indices) {
        grid[i / cols][i % cols] = plain[i]
    }

    val sb = StringBuilder()
    for (col in 0 until cols) {
        for (row in 0 until rows) {
            if (grid[row][col] != ' ') {
                sb.append(grid[row][col])
            }
        }
        if (col < cols - 1) sb.append(' ')
    }
    println(sb.toString())
}
