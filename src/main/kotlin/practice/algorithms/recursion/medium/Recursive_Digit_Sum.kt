package practice.algorithms.recursion.medium

// 方法1
// 其实没啥好说的，照着题目的意思干就行了
// 然后由于初始字符串如果过大，再repeat就有可能溢出
// 所以我们分成k段，然后合并k段结果再做就行了
// 当然，肯定有更简单的额方案，
// 不过这里我们重点在于理解递归，有助于我们培养程序思维
// AC 12/12
const val zero = '0'.toLong()
fun superDigit(num: String): Long {
    if (num.length == 1) return num.toLong()
    var x = 0L
    for (i in num.indices) {
        x = x + num[i].toLong() - zero
    }
    return superDigit(x.toString())
}

fun main(args: Array<String>) {
    val nk = readLine()!!.split(" ")
    val n = nk[0]
    val k = nk[1].trim().toInt()
    val result = superDigit((superDigit(n) * k).toString())
    println(result)
}