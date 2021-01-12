package practice.algorithms.search.easy

fun balancedSums(arr: Array<Int>, n: Int): String {
    // 方法1
    // 求出左到右和右到左的前缀和
    // 找出相等的那一个，那么它左右两边和就相等
    // 找不出来就没有解
    // Passed
    val prefixSumOfLeft2Right = IntArray(n)
    val prefixSumOfRight2Left = IntArray(n)

    var sum1 = 0;
    var sum2 = 0;
    for (i in 0 until n) {
        sum1 += arr[i]
        prefixSumOfLeft2Right[i] = sum1
        sum2 += arr[n - 1 - i]
        prefixSumOfRight2Left[n - 1 - i] = sum2
    }

    for (i in 0 until n) {
        if (prefixSumOfRight2Left[i] == prefixSumOfLeft2Right[i]) {
            return "YES"
        }
    }
    return "NO"
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (TItr in 1..t) {
        val n = readLine()!!.trim().toInt()
        val arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
        val result = balancedSums(arr, n)
        println(result)
    }
}
