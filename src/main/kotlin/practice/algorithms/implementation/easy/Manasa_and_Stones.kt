package practice.algorithms.implementation.easy

import java.util.*
import kotlin.collections.*

// Complete the stones function below.
fun stones(n: Int, a: Int, b: Int): Array<Int> {
    // 方法1
    // 模拟法（暴力）
    // 可以分析得出，第一个石头是0，第二个是0 + a和0+b
    // 第三个是(0+a) + (0 + a), (0 + a) + (0 + b) | (0 + b) + (0 + a), (0+b) +(0 + b) = 2a, a + b| b + a, 2b
    // 可以看出有重复的a + b，所以我们用hashset来保存
    // 然后每次将set中所有的数据都取出来，每个+a和+b，再保存进set中
    // 由于数据量不大（最大10个石头），所以这个方法不会超时（再多几个就超了）
    // Passed
//    val sets = HashSet<Int>()
//    sets.add(0)
//    for (i in 1 until n) {
//        val list = mutableListOf<Int>()
//        list.addAll(sets)
//        sets.clear()
//        for (x in list) {
//            sets.add(x + a)
//            sets.add(x + b)
//        }
//    }
//    val answer = sets.toTypedArray()
//    answer.sort()
//    return answer

    // 方法2
    // 数学方法，这个是某个大神写的，
    // 第一个是0，我们不管，然后记录剩下的石头n - 1
    // 如果a == b，那么返回 a * (n - 1)即可，
    // 如果a < b（a是小的那个，b是大的那个），
    // 那么最后一块石头的
    //   最小的情况就是 min = a * (n - 1)
    //   最大的情况就是 max = b * (n - 1)
    //   而剩下的只可能在这两个之间，
    //   我们只需要找到a，b的差值diff
    //   然后从min + diff，一直到 > max，这些结果就都是可能的结果
    // 这个方法直接避免了重复值，找到了所有的值
    // 通过大神的解题，我吸收一下思想哈，
    // 如果是求这种数值可能性的情况，那么是不是首先找出上下边界，
    // 然后再找出边界内部可能之间的规律，得出公式，最后再求证这个公式
    // Passed
    if (a == b) return arrayOf(a * (n - 1))
    var min = Math.min(a, b) * (n - 1)
    val max = Math.max(a, b) * (n - 1)
    val diff = Math.abs(a - b)
    val answer = mutableListOf<Int>()
    while (min <= max) {
        answer.add(min)
        min += diff
    }
    return answer.toTypedArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val T = scan.nextLine().trim().toInt()

    for (TItr in 1..T) {
        val n = scan.nextLine().trim().toInt()

        val a = scan.nextLine().trim().toInt()

        val b = scan.nextLine().trim().toInt()

        val result = stones(n, a, b)

        println(result.joinToString(" "))
    }
}
