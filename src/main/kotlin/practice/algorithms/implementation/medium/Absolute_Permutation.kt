package practice.algorithms.implementation.medium

import java.util.*

// 方法1
// 看到题很容易想到高斯的传说，1到100的5050
// 当我们遇到第x个数的时候，我们需要向前k个距离的数字进行交换，
// 如果我们遇到不能交换的数字，自然就无法完成这个操作
// 当我们迭代向前的时候，我们不需要管i - k的位置
// 这里需要注意的是，我们需要有个数组来记录哪些数字已经做了交换了
// 不需要再去处理了，那么我们遇到一个交换过的数字需要交换，也说明无法完成这个操作
// AC
fun solution1(n: Int, k: Int): Array<Int> {
    val arr = (1..n).map { it }.toTypedArray()
    val used = BooleanArray(n)
    for (i in 0 until n) {
        if (used[i]) continue
        val j = i + k
        if (j >= n || used[j]) return arrayOf(-1)
        arr[i] = arr[j].also { arr[j] = arr[i] }
        used[i] = true
        used[j] = true
    }
    return arr
}

// 方法2
// 通过观察数组，我们知道以下3个情况：
// 1，如果K是0，这个就不说了，就是没变，直接返回数组
// 2，如果N是奇数，那么答案不存在，
// 3，如果N是偶数，但是N不能分成2 * K段，也就是N % (2 * K) != 0，那么答案也不存在，
//    因为我们要保证每个2 * K成为一段，这样这个段里面才可以相互交换
// 例如 1 2 3 4，k=1，那么我们分成了两段，[1 2] [3 4] 然后内部交换后成为[2 1] [4 3]得到答案
// 再如 1 2 3 4，k=2，那么我们只能分成1段，[1 2 3 4]，内部交换成为[3 4 1 2]
// AC
fun solution2(n: Int, k: Int): Array<Int> {
    val arr = (0..n).map { it }.toTypedArray()
    if (k == 0) return arr.copyOfRange(1, n + 1)
    if (n % 2 != 0) return arrayOf(-1)
    if (n % (2 * k) != 0) return arrayOf(-1)
    for (i in 1..n step 2 * k) { // 每个2 * k段
        for (j in 1..k) {
            val x = i + j - 1
            val y = x + k
            arr[x] = arr[y].also { arr[y] = arr[x] }
        }
    }
    return arr.copyOfRange(1, n + 1)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val t = scan.nextLine().trim().toInt()
    for (tItr in 1..t) {
        val nk = scan.nextLine().split(" ")
        val n = nk[0].trim().toInt()
        val k = nk[1].trim().toInt()
        val result = solution2(n, k)
        println(result.joinToString(" "))
    }
}
