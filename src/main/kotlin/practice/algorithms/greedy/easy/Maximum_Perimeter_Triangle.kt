package practice.algorithms.greedy.easy

fun main() {
    // 方法1
    // 排序sticks
    // 然后从最大的值开始检查是否是合法的三角形
    // 合法的三角形就是任意两边的和大于第三边
    // 得到的第一个合法的三角形就是周长最大的
    // Passed
    val n = readLine()!!.trim().toInt()
    val sticks = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
    sticks.sortDescending()
    for (i in 0 until n - 2) {
        for (j in i + 1 until n - 1) {
            for (k in j + 1 until n) {
                if (isValid(sticks[i], sticks[j], sticks[k])) {
                    println("${sticks[k]} ${sticks[j]} ${sticks[i]}")
                    return
                }
            }
        }
    }
    println(-1)
}

fun isValid(a: Int, b: Int, c: Int) = a + b > c && a + c > b && b + c > a
