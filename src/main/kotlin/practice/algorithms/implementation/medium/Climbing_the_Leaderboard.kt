package practice.algorithms.implementation.medium

//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

// 方法1
// 排序ranked，然后去除重复的数字（这里kotlin可以使用distinct()方法,rust有dedup()方法）
// 这个时候我们得到的数组leaderboard是自然顺序的，所以排名正好是相反的
// 迭代player的得分，通过二分查找：
//    如果找到，那么说明我们的排名是并列的，直接取那个并列的排名；
//    如果没有找到，那么说明我们需要上榜，这里的binarySearch()能够返回一个插入数据的正确位置
//    我们将这个数字插入当前这个位置，而这个位置就是我们当前的排名；
// 注意：排名是与自然顺序相反，所以要用当前leaderboard.size - at
//      kotlin的二分如果没有找到返回的是一个负数，通过这个-(负数+1)能够得到正确的位置（见kotlin文档）
// AC
fun climbingLeaderboard(ranked: Array<Int>, player: Array<Int>): Array<Int> {
    ranked.sort()
    val leaderboard = ranked.distinct().toMutableList()
    val answer = mutableListOf<Int>()
    for (point in player) {
        var at = leaderboard.binarySearch(point)
        if (at < 0) {
            at = -(at + 1)
            leaderboard.add(at, point)
        }
        answer.add(leaderboard.size - at)
    }
    return answer.toTypedArray()
}

fun main(args: Array<String>) {
    val rankedCount = readLine()!!.trim().toInt()
    val ranked = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    val playerCount = readLine()!!.trim().toInt()
    val player = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = climbingLeaderboard(ranked, player)
    println(result.joinToString("\n"))
}

