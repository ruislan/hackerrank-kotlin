package practice.algorithms.strings.medium

import java.util.*

// 方法1
// 简单来说其实就是找出valid的情况就行了，
// 先统计频率，然后求出最大值和最大值的数量，最小值和最小值的数量
// 然后如果最大值和最小值相等，那么就肯定是valid
// 如果最大值比最小值大1以上：
//    那么就看数组是不是只有最大值和最小值组成
//       如果是，且最小值的数量只有1个，且最大值是1，那么就能valid，
//       例如：a、b:4, c:2。ab各有4个，c有2个，最大致是4，最小值是2，虽然最小值只有1个，但是也无法改动1次就valid。
//       例如：a:4, b、c:2。a有4个，bc各有2个，最大值是4，它的数量虽然只有1个，但是却无法只改动1次就valid
//    否则，肯定都是不合格的了
// 如果最大值比最小值小1个及以下：
//    那么就看最大值或者最小值的数量是不是只有1个，因为我们可以随便调1个就能解决
// 最后就没有合格情况了
// AC
fun isValid(s: String): String {
    val freq = IntArray(26)
    for (ch in s) freq[ch - 'a'] += 1
    val min = freq.filter { it != 0 }.min()!!
    val minCount = freq.filter { it == min }.count()
    val max = freq.filter { it != 0 }.max()!!
    val maxCount = freq.filter { it == max }.count()
    if (max == min) return "YES"
    if (max - min > 1) {
        if (maxCount * max + minCount * min == s.length && (minCount == 1 && min == 1)) return "YES"
        return "NO"
    }
    if (maxCount == 1 || minCount == 1) return "YES"
    return "NO"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val s = scan.nextLine()
    val result = isValid(s)
    println(result)
}
