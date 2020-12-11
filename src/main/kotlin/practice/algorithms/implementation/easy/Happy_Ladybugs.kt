package practice.algorithms.implementation.easy

import java.util.*

// Complete the happyLadybugs function below.
fun happyLadybugs(b: String): String {
    // 方法1
    // 如果凑成相同的都在一起，那么只要有一个空格，所有的字母都可以通过这个空格移动，
    // 有空格的情况，
    //    如果有的字母只有1个，那怎么移动都凑不起，返回NO
    //    否则，返回YES
    // 现在来考虑没有空格的情况，
    //    如果本身就是凑好形状了，那么直接就返回YES
    //    否则，返回NO
    // Passed
//    val freq = HashMap<Char, Int>()
//    var blank = 0
//    for (x in b) {
//        if (x == '_') blank += 1
//        else {
//            if (freq[x] == null) freq[x] = 0
//            freq[x] = freq[x]!! + 1
//        }
//    }
//    if (blank == 0) {
//        var cnt = 1
//        for (i in 1 until b.length) {
//            when {
//                b[i] == b[i - 1] -> cnt += 1
//                cnt == 1 -> return "NO"
//                else -> cnt = 1
//            }
//        }
//        if (cnt == 1) return "NO"
//    } else {
//        for (entry in freq)
//            if (entry.value == 1)
//                return "NO"
//    }
//    return "YES"

    // 方法2
    // 方法1的精简版本
    if (b.contains("_")) {
        for (entry in b.groupBy { it }) {
            if (entry.key != '_' && entry.value.size == 1) return "NO"
        }
    } else {
        val n = b.length
        for (i in b.indices) {
            if (!((i > 0 && b[i] == b[i - 1]) || (i + 1 < n && b[i] == b[i + 1]))) return "NO"
        }
    }
    return "YES"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val g = scan.nextLine().trim().toInt()

    for (gItr in 1..g) {
        val n = scan.nextLine().trim().toInt()

        val b = scan.nextLine()

        val result = happyLadybugs(b)

        println(result)
    }
}
