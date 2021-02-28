package practice.algorithms.bit.medium

import java.util.*

// 方法1
// 这里我们需要的知识是(x xor x = 0)
// (x xor y xor z = y xor z xor x)也就是交换的结果是一样的
// 那么，
// 假设只有1个数字，那没得说，只能返回它自己
// 假设有2个数字，我们需要检查的是
//    a. [1] [2]
//    b. [1 2]
//    这里我们看到，a和b是一样的，可以相互抵消(x xor x = 0)
// 假设有3个数字，我们需要检查的是
//    a.  [1] [2] [3]
//    b.  [1 2]  [2 3]
//    c.  [1   2   3]
//    这里我们看到，实际上a和c是一样的可以互相抵消
//    而b中的2有两个，也可以抵消，那么只剩下1和3
// 仿佛有点规律了，就是偶数好像可以直接抵消掉都是0，
// 奇数是1个取arr[0]， 3个是arr[0] xor arr[2]，
// 那么到底是取头尾呢，还是取0 2 4 6……这样的偶数位置呢？
// 为了验证一下，我们继续4个数字和5个数字，
// 这里就不细写了，4个数字的结果就是a:d消了，b:c消了
// 5个数字的结果就是a:e消了，b:d消了，剩下c，而c行中剩下的正好是arr[0] xor arr[2] xor arr[4]
// 我们知道了偶数是0，奇数就是每个偶数索引之间xor即可
// AC 14/14
fun sansaXor(arr: Array<Int>): Int {
    val n = arr.size
    if (n < 2) return arr[0]
    if (n % 2 == 0) return 0
    var answer = 0
    for (i in 0 until n step 2) {
        answer = answer xor arr[i]
    }
    return answer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val t = scan.nextLine().trim().toInt()
    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()
        val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
        val result = sansaXor(arr)
        println(result)
    }
}
