package practice.algorithms.greedy.medium

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()
    val k = readLine()!!.trim().toInt()
    val arr = IntArray(n)
    for (i in 0 until n) arr[i] = readLine()!!.trim().toInt()
    // 方法1
    // 贪婪加上滑动窗口
    // 先排序，然后设置一个长度为k的窗口
    // 移动窗口，
    // 求出每次窗口的最大最下值的差值的最小的那个就是答案
    // AC
    arr.sort()
    var answer = arr[k - 1] - arr[0]
    for (i in k until arr.size) {
        answer = Math.min(answer, arr[i] - arr[i - k + 1])
    }
    println(answer)
}
