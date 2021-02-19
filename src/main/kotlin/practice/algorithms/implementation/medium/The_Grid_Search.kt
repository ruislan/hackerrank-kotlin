package practice.algorithms.implementation.medium

import java.util.*

// 方法1
// 因为数据量不大，最大1000，所以暴力解法可行
// 当出现第一行相等的时候，依次判断所有的p的行
// 我们只需要检查的范围，row在0..gR-pR范围，col在0..gC-gR范围
// 因为超过这个范围，p就不可能贴合了。
// AC
fun gridSearch(g: Array<String>, p: Array<String>, gR: Int, gC: Int, pR: Int, pC: Int): String {
    for (row in 0..gR - pR) {
        for (col in 0..gC - pC) {
            var mRow = 0
            while (mRow < pR && g[row + mRow].substring(col, col + pC) == p[mRow]) {
                mRow += 1
            }
            if (mRow == pR) return "YES"
        }
    }
    return "NO"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val t = scan.nextLine().trim().toInt()
    for (tItr in 1..t) {
        val gRC = scan.nextLine().split(" ")
        val gR = gRC[0].trim().toInt()
        val gC = gRC[1].trim().toInt()
        val g = Array(gR) { "" }
        for (i in 0 until gR) {
            g[i] = scan.nextLine()
        }
        val pRC = scan.nextLine().split(" ")
        val pR = pRC[0].trim().toInt()
        val pC = pRC[1].trim().toInt()
        val p = Array(pR) { "" }
        for (i in 0 until pR) {
            p[i] = scan.nextLine()
        }
        val result = gridSearch(g, p, gR, gC, pR, pC)
        println(result)
    }
}
