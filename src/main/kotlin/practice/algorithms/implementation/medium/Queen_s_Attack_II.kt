package practice.algorithms.implementation.medium

import java.util.*
import kotlin.collections.*

// 方法1
// 这里只要模拟路径就可以了
// 需要注意的地方就是obstacles需要放到hashset里面，这样比对就是O(1)
// AC 21/21

val direction = arrayOf(
        Pair(0, -1),
        Pair(1, -1),
        Pair(-1, -1),
        Pair(1, 0),
        Pair(-1, 0),
        Pair(1, 1),
        Pair(0, 1),
        Pair(-1, 1)
)

fun forward(qx: Int, qy: Int, fx: Int, fy: Int, n: Int, obstacles: HashSet<Pair<Int, Int>>): Int {
    var x = qx + fx
    var y = qy + fy
    var step = 0
    while (x in 1..n && y in 1..n && !obstacles.contains(Pair(x, y))) {
        x += fx
        y += fy
        step += 1
    }
    return step
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val nk = scan.nextLine().split(" ")
    val n = nk[0].trim().toInt()
    val k = nk[1].trim().toInt()

    val r_qC_q = scan.nextLine().split(" ")
    val r_q = r_qC_q[0].trim().toInt()
    val c_q = r_qC_q[1].trim().toInt()

    val obstacles = HashSet<Pair<Int, Int>>()
    for (i in 0 until k) {
        val pos = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
        obstacles.add(Pair(pos[1], pos[0]))
    }

    var answer = 0
    for (d in direction) {
        answer += forward(c_q, r_q, d.first, d.second, n, obstacles)
    }

    println(answer)
}
