package practice.algorithms.graph.medium


fun main(args: Array<String>) {
    // 方法1
    // 并查集将所有的相同的集合放在一起
    // 然后两两组合就行了

    val np = readLine()!!.split(" ")
    val n = np[0].trim().toInt()
    val p = np[1].trim().toInt()
    val uf = UnionFind(n)
    for (i in 0 until p) {
        val astronaut = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
        uf.union(astronaut[0], astronaut[1])
    }

    var answer = 0L
    var sum = 0L
    for (i in 0 until n) {
        if (uf.parent[i] == i) {
            answer += sum * uf.sz[i]
            sum += uf.sz[i]
        }
    }

    println(answer)
}
