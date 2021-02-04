package practice.algorithms.bit.easy

fun main() {
    val n = readLine()!!.trim().toInt()
    val arr = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
    // 方法1
    // xor可以将两个相同的数字变成0
    // 0和任何数字xor都是那个数字
    // 所以所有的数字xor，剩下的那个就是结果
    // Passed
    var x = 0
    for (i in 0 until n) x = x xor arr[i]
    println(x)
}
