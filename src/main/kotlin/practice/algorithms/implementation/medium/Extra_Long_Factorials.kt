package practice.algorithms.implementation.medium

import java.math.BigDecimal

// 方法1
// 这题没啥说的，用BigDecimal就可以解决了
// 而有些编程语言的标准库是没有BigDecimal的
// 这也算是JVM系列的福利吧
// AC
fun main(args: Array<String>) {
    val n = readLine()!!.trim().toLong()
    var answer = BigDecimal.ONE
    for (i in 1..n) answer = answer.multiply(BigDecimal.valueOf(i))
    println(answer)
}
