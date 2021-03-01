package practice.algorithms.bit.medium

import java.util.*


// 方法1
// 设置最大的2的幂为max，
// max就是二进制的1往左边移到数字x的二进制最左边那个1的位置
// 这里怎么得到最左边的那个1，我这里用最朴素的方式就是求得左边的leading_zeros
// 然后1向左移位到63 - leading_zeros即可，
// 初始时x = n，每次判断max == x，根据规则减半，
// 注意这里Rust都好说，因为有u64
// 而用Java就要考虑到移位不带符号， 否则就会出现死循环了
// 如果max != x根据规则减少max即可
// AC 19/19
fun counterGame(n: Long): String {
    var x = n
    var isLouiseWin = true

    while (true) {
        val max = 1L shl (63 - java.lang.Long.numberOfLeadingZeros(x))
        if (max == x) {
            x = x ushr 1
        } else {
            x -= max
        }
        if (x == 1L) break
        isLouiseWin = !isLouiseWin
    }

    return if (isLouiseWin) "Louise" else "Richard"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val t = scan.nextLine().trim().toInt()
    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toLong()
        val result = counterGame(n)
        println(result)
    }
}
