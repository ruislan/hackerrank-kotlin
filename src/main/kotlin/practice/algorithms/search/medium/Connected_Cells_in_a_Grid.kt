package practice.algorithms.search.medium

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()
    val m = readLine()!!.trim().toInt()

    val matrix = Array<Array<Int>>(n, { Array<Int>(m, { 0 }) })

    for (i in 0 until n) {
        matrix[i] = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    // 方法1
    // 并查集干净利落的解决连通性问题
    // 所有八个方向的为1的加入进uf
    // 然后最后得到最大的那个集合数量即可
    // AC
    val uf = UnionFind(n * m)
    for (row in 0 until n) {
        for (col in 0 until m) {
            if (matrix[row][col] == 1) {
                val index = row * m + col
                if (row > 0 && matrix[row - 1][col] == 1) uf.union(index, index - m)
                if (row < n - 1 && matrix[row + 1][col] == 1) uf.union(index, index + m)
                if (col > 0 && matrix[row][col - 1] == 1) uf.union(index, index - 1)
                if (col < m - 1 && matrix[row][col + 1] == 1) uf.union(index, index + 1)
                if (row > 0 && col > 0 && matrix[row - 1][col - 1] == 1) uf.union(index, index - m - 1)
                if (row < n - 1 && col > 0 && matrix[row + 1][col - 1] == 1) uf.union(index, index + m - 1)
                if (row > 0 && col < m - 1 && matrix[row - 1][col + 1] == 1) uf.union(index, index - m + 1)
                if (row < n - 1 && col < m - 1 && matrix[row + 1][col + 1] == 1) uf.union(index, index + m + 1)
            }
        }
    }
    println(uf.sz.max())
}

class UnionFind(val n: Int) {
    val parent = (0 until n).map { it }.toIntArray()
    val rank = IntArray(n)
    val sz = IntArray(n) { 1 }
    var setCount = n

    fun find(x: Int): Int {
        if (x != parent[x]) parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX == rootY) return false
        when {
            rank[rootX] > rank[rootY] -> {
                parent[rootY] = parent[rootX]
                sz[rootX] += sz[rootY]
            }
            rank[rootX] < rank[rootY] -> {
                parent[rootX] = parent[rootY]
                sz[rootY] += sz[rootX]
            }
            else -> {
                parent[rootY] = parent[rootX]
                sz[rootX] += sz[rootY]
                rank[rootX] += 1
            }
        }
        setCount -= 1
        return true
    }
}
