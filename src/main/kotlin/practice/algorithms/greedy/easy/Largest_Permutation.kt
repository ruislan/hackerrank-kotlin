package practice.algorithms.greedy.easy

import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val nk = readLine()!!.split(" ")
    val n = nk[0].trim().toInt()
    val k = nk[1].trim().toInt()
    val arr = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()

    val pq = PriorityQueue<Int> { a, b -> b - a }
    var cnt = 0
    for (i in n downTo 1) {
        if (cnt == k) break
        pq.add(i)
        cnt += 1
    }
    val changed = HashSet<Int>()
    for (i in 0 until n) {
        if (changed.size == k) break    
        if (arr[i] < pq.peek()) {
            pq.add(arr[i])
            arr[i] = pq.poll()
        }
    }

    println(arr.joinToString(" "))
}
