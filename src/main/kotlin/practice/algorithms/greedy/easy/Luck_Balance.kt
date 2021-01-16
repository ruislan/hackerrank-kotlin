package practice.algorithms.greedy.easy

fun main(args: Array<String>) {
    // 方法1
    // 直接排序重要的contest，然后取重要的前k个加上，后面的减去
    // 不重要的都可以直接加
    // Passed
    val nk = readLine()!!.split(" ")
    val n = nk[0].trim().toInt()
    val k = nk[1].trim().toInt()
    val importantList = ArrayList<Int>()
    var answer = 0
    for (i in 0 until n) {
        val contest = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
        if (contest[1] == 1) importantList.add(contest[0])
        else answer += contest[0]
    }
    importantList.sortDescending()
    for (i in importantList.indices) {
        if (i < k) answer += importantList[i]
        else answer -= importantList[i]
    }
    println(answer)
}
