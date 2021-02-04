package practice.algorithms.graph.medium

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val vars = readLine()!!.split(" ")
        val n = vars[0].trim().toInt()
        val m = vars[1].trim().toInt()
        val cLib = vars[2].trim().toLong()
        val cRoad = vars[3].trim().toLong()

        // 方法1
        // 并查集解决连通分量
        // 各个城市能够联通的就多一条公路
        // 然后有多少个集合就有多少个图书馆*图书馆价值 + 公路条数*公路价值
        // 最后与每个城市修建一个图书馆进行比较，取最小的那个
        // AC
        val uf = UnionFind(n)
        for (i in 0 until m) {
            val city = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
            uf.union(city[0] - 1, city[1] - 1)
        }

        val answer1 = cLib * uf.setCount + cRoad * (n - uf.setCount)
        val answer2 = cLib * n

        println(Math.min(answer1, answer2))
    }
}
