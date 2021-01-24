package practice.algorithms.greedy.easy

fun main(args: Array<String>) {
    val nk = readLine()!!.split(" ")
    val n = nk[0].trim().toInt()
    val k = nk[1].trim().toInt()
    val arr = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()

    // 方法1
    // 通过每次交换子数组中的第一个元素和该数组中最大元素的次数
    // 最多交换k次
    // 用kotlin提交会有2个TestCase超时，
    // 一摸一样的换成Java8写就不会超时，：（
    var max = n
    var swapCount = 0
    for (i in 0 until n) {
        if (swapCount == k) break
        if (arr[i] != max) {
            var j = i + 1
            while (j < n && arr[j] != max) j += 1
            arr[j] = arr[i]
            arr[i] = max
            swapCount += 1
        }
        max -= 1
    }

    println(arr.joinToString(" "))
}