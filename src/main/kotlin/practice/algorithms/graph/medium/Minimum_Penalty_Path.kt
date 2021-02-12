package practice.algorithms.graph.medium

import java.util.*

fun main(args: Array<String>) {
    val nm = readLine()!!.split(" ")
    val n = nm[0].trim().toInt()
    val m = nm[1].trim().toInt()

    val graph = HashMap<Int, MutableList<Pair<Int, Int>>>()
    for (i in 0 until m) {
        val edge = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
        val u = edge[0]
        val v = edge[1]
        graph.putIfAbsent(u, mutableListOf())
        graph.putIfAbsent(v, mutableListOf())
        graph[u]!!.add(v to edge[2])
        graph[v]!!.add(u to edge[2])
    }

    val ab = readLine()!!.split(" ")
    val a = ab[0].trim().toInt()
    val b = ab[1].trim().toInt()

    val used = Array(n + 1) { BooleanArray(1024) }
    val que = ArrayDeque<Pair<Int, Int>>()
    que.addLast(a to 0)

    while (que.isNotEmpty()) {
        val node = que.removeFirst()
        used[node.first][node.second] = true
        val neighbors = graph[node.first]
        if (neighbors != null) {
            for (neighbor in neighbors) {
                val to = neighbor.first
                val cost = neighbor.second or node.second
                if (!used[to][cost]) {
                    used[to][cost] = true
                    que.addLast(to to cost)
                }
            }
        }
    }
    var answer = -1
    for (i in 0 until 1024) {
        if (used[b][i]) {
            answer = i
            break
        }
    }
    println(answer)
}
