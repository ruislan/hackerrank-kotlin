package practice.algorithms.greedy.easy

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()
    val A = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
    val B = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()

    // 方法1
    // 两个数组进行排序
    // 然后双指针对A[i] == B[j]的进行编组Pair
    // 有个细节要注意，如果全部都匹配，那么你还是必须得改1个
    // 也就是说如果有10个，但是匹配了10个，你必须改1个，结果是9个
    // Passed
    A.sort()
    B.sort()
    var matched = 0
    var j = 0
    for (i in 0 until n) {
        while (j < n && A[i] > B[j]) j += 1
        if (j >= n) break
        if (A[i] == B[j]) {
            matched += 1
            j += 1
        }
    }
    if (matched == n) matched -= 1
    else if (matched < n) matched += 1
    println(matched)
}
