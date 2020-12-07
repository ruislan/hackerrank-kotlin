package practice.algorithms.implementation.easy

import java.util.*

// Complete the chocolateFeast function below.
fun chocolateFeast(n: Int, c: Int, m: Int): Int {
    // 方法1
    // 简单来说就是m个包装可以换1个新的巧克力，然后这个新的巧克力又产生了1个包装
    // 首先我们求出初始用钱吃了多少个，得到了多少个包装
    // 然后当我们的包装总数比m大的话，那么更换x个新的，产生x个包装，
    // 剩下的包装 + x个包装形成新的包装总数，然后循环直到包装比m小，即是不能再换
    // Passed
    var eats = n / c
    var wrappers = eats
    while (wrappers >= m) {
        val freeEats = wrappers / m
        wrappers = wrappers % m + freeEats
        eats += freeEats
    }
    return eats
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val ncm = scan.nextLine().split(" ")

        val n = ncm[0].trim().toInt()

        val c = ncm[1].trim().toInt()

        val m = ncm[2].trim().toInt()

        val result = chocolateFeast(n, c, m)

        println(result)
    }
}
