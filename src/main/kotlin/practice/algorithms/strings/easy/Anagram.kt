package practice.algorithms.strings.easy

import java.util.*
import kotlin.collections.*

// Complete the anagram function below.
fun anagram(s: String): Int {
    // 方法1
    // 两个子串长度要一样：那么只能平均分了，所以长度为奇数的都可以淘汰了
    // 分出来的子串为a,b
    // 统计a中字符的频率到hashmap中
    // 如果b中的字符在hashmap中，那么说明不用替换它，hashmap[b[i]] -= 1
    // 最后统计hashmap中所有values的值的和就是要替换的数量
    if (s.length and 1 == 1) return -1

    val map = HashMap<Char, Int>()
    val half = s.length shr 1
    for (i in s.indices) {
        val freq = map[s[i]] ?: 0
        if (i < half) {
            map[s[i]] = freq + 1
        } else {
            if (freq > 0) map[s[i]] = freq - 1
        }
    }
    return map.values.sum()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = anagram(s)

        println(result)
    }
}
