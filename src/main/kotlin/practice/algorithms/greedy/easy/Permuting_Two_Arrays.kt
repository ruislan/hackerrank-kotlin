package practice.algorithms.greedy.easy

fun main(args: Array<String>) {
    // 方法1
    // A顺排序，B倒排序
    // 这样保证了每一个A[i] + B[i]的下限最高
    // 如果这个下限都比k小，那么就没办法了，只有“NO”
    // 否则YES
    val q = readLine()!!.trim().toInt()
    outer@ for (qItr in 1..q) {
        val nk = readLine()!!.split(" ")
        val n = nk[0].trim().toInt()
        val k = nk[1].trim().toInt()
        val A = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
        val B = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
        A.sort()
        B.sortDescending()
        for (i in 0 until n) {
            if (A[i] + B[i] < k) {
                println("NO")
                continue@outer
            }
        }
        println("YES")
    }
}
