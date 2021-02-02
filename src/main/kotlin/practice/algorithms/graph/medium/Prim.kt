package practice.algorithms.graph.medium


import java.util.*

// 题目：Prim's (MST) : Special Subtree
// 方法
// 选择一个出发点，本题直接提供了一个
// 然后找到他的所有邻居放入优先级队列（小顶堆），
// 每次从优先级队列中取出第一个（也即是选择花费最小的那个）
// 将他放入最小生成树MST，然后将这个边的两端中没有访问过的节点
// 取出来，把这个节点所有邻接边中的对手节点都没有访问过的，都放入优先级队列
// 直到这个优先级队列没有更多的内容
fun main(args: Array<String>) {
    val nm = readLine()!!.split(" ")
    val n = nm[0].trim().toInt()
    val m = nm[1].trim().toInt()

    val graph = HashMap<Int, MutableList<Int>>()
    val costs = Array(n) { Array(n) { 0 } }
    for (i in 0 until m) {
        val edge = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
        val a = edge[0] - 1
        val b = edge[1] - 1
        // 创建邻接边的图
        graph.putIfAbsent(a, mutableListOf())
        graph.putIfAbsent(b, mutableListOf())
        graph[a]!!.add(b)
        graph[b]!!.add(a)
        // 创建花费
        costs[a][b] = edge[2]
        costs[b][a] = edge[2]
    }

    val start = readLine()!!.trim().toInt() - 1
    var minCost = 0
    val visited = BooleanArray(n)
    val minPQ = PriorityQueue<Array<Int>> { e1, e2 -> costs[e1[0]][e1[1]] - costs[e2[0]][e2[1]] }
    // 初始化起点的所有邻接边
    for (node in graph[start]!!) {
        minPQ.add(arrayOf(start, node))
    }
    while (minPQ.isNotEmpty()) {
        val edge = minPQ.poll()
        // 如果边的两个节点都有访问过，则不需要处理
        if (visited[edge[0]] && visited[edge[1]]) continue

        minCost += costs[edge[0]][edge[1]]

        // 把两个节点的所有的没有访问过的节点的领接边放入小顶堆
        if (!visited[edge[0]]) {
            visited[edge[0]] = true
            for (node in graph[edge[0]]!!) {
                if (!visited[node]) minPQ.add(arrayOf(edge[0], node))
            }
        }
        if (!visited[edge[1]]) {
            visited[edge[1]] = true
            for (node in graph[edge[1]]!!) {
                if (!visited[node]) minPQ.add(arrayOf(edge[1], node))
            }
        }
    }

    println(minCost)
}
