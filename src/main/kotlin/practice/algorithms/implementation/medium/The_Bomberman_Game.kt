package practice.algorithms.implementation.medium

import java.util.*

// 方法1
// 简单的推演范例就能看出来，
// 如果n是偶数，必然全部都是O
// 现在要考虑的就是单数，
// 如果n比较小，那么很简单，就是不停的模拟就行了
// 而n比较大的话，就会超时
// 这个时候我们就要分析规律了，
// 我们多找几个案例来尝试，会发现，当n到了n%4 + 4 if n > 4的时候
// 这个变化就处于稳定且规律的来回变化了，也就是说这个n最多是7
// 至于证明，看官方解吧
// AC 26/26
fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val rcn = scan.nextLine().split(" ")
    val r = rcn[0].trim().toInt()
    val c = rcn[1].trim().toInt()
    var n = rcn[2].trim().toInt()

    var grid1 = Array(r) { CharArray(c) }
    for (i in 0 until r) {
        val gridItem = scan.nextLine()
        grid1[i] = gridItem.toCharArray()
    }

    if (n % 2 == 0) {
        val sb = StringBuffer()
        for (i in 0 until r) {
            for (j in 0 until c) {
                sb.append('O')
            }
            sb.append('\n')
        }
        println(sb.toString())
        return
    }
    n /= 2
    n = Math.min(n, (n + 1) % 2 + 1)
    for (i in 1..n) {
        val grid2 = Array(r) { CharArray(c) { 'O' } }
        for (row in 0 until r) {
            for (col in 0 until c) {
                if (grid1[row][col] == 'O') {
                    grid2[row][col] = '.'
                    if (row > 0) grid2[row - 1][col] = '.'
                    if (col > 0) grid2[row][col - 1] = '.'
                    if (row < r - 1) grid2[row + 1][col] = '.'
                    if (col < c - 1) grid2[row][col + 1] = '.'
                }
            }
        }
        grid1 = grid2
    }

    val sb = StringBuffer()
    for (i in 0 until r) {
        for (j in 0 until c) {
            sb.append(grid1[i][j])
        }
        sb.append('\n')
    }
    println(sb.toString())
}
