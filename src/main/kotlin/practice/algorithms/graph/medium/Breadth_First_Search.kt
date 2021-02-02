import java.util.*
import kotlin.collections.*

/**
 * BFS就是队列放进去搜索就行了
 * AC
 */
fun bfs(n: Int, m: Int, edges: Array<Array<Int>>, s: Int): Array<Int> {
    val graph = HashMap<Int, HashSet<Int>>()
    for (edge in edges) {
        graph.putIfAbsent(edge[0], HashSet())
        graph.putIfAbsent(edge[1], HashSet())
        graph[edge[0]]!!.add(edge[1])
        graph[edge[1]]!!.add(edge[0])
    }

    val que = ArrayDeque<Int>()
    val visited = BooleanArray(n + 1)
    val distTo = Array(n + 1) { -1 }

    que.addLast(s)
    visited[s] = true

    var distance = 0
    while (que.isNotEmpty()) {
        for (i in que.indices) {
            val node = que.removeFirst()
            distTo[node] = distance
            if (graph.containsKey(node)) {
                for (voisin in graph[node]!!) {
                    if (!visited[voisin]) {
                        visited[voisin] = true
                        que.addLast(voisin)
                    }
                }
            }
        }
        distance += 6
    }

    val answer = mutableListOf<Int>()
    for (i in 1..n) {
        if (i != s) {
            answer.add(distTo[i])
        }
    }

    return answer.toTypedArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val nm = scan.nextLine().split(" ")
        val n = nm[0].trim().toInt()
        val m = nm[1].trim().toInt()
        val edges = Array<Array<Int>>(m, { Array<Int>(2, { 0 }) })
        for (i in 0 until m) {
            edges[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
        }

        val s = scan.nextLine().trim().toInt()
        val result = bfs(n, m, edges, s)
        println(result.joinToString(" "))
    }
}
