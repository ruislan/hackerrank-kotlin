package practice.algorithms.dp.medium

import java.util.*
import java.math.*

// 方法1
// 有BigInteger真的蛮简单的
// 这题如果用递归的话，要用hashmap来存储计算结果，也就是memo
// 来避免大量的重复计算
// AC
fun fibonacciModified(t1: Long, t2: Long, n: Int): BigInteger {
    if (n == 1) return t1.toBigInteger()
    if (n == 2) return t2.toBigInteger()
    var x1 = t1.toBigInteger()
    var x2 = t2.toBigInteger()
    var x = BigInteger.ZERO
    for (i in 3..n) {
        x = x1.plus(x2.pow(2))
        x1 = x2
        x2 = x
    }
    return x
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val t1T2n = scan.nextLine().split(" ")
    val t1 = t1T2n[0].trim().toLong()
    val t2 = t1T2n[1].trim().toLong()
    val n = t1T2n[2].trim().toInt()
    val result = fibonacciModified(t1, t2, n)
    println(result)
}
