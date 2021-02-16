package practice.algorithms.implementation.medium

import java.util.*

// https://www.hackerrank.com/challenges/bigger-is-greater/problem

// 方法1
// 首先我们把所有的字符转换成数字来思考，会容易一丢丢。
// 我们假设我们处在一个中间的位置i，那么我们知道
//    这个位置的右边一定是非递增排列的（否则我们无法到达这个位置）
//    这个位置比他的右边一个要小（否则我们不会停下来）
//    这个位置的左边我们不需要知道，因为这个位置就是我们要处理的位置
// 由于右边都是非递增排列，那么表示右边处于当前所组成最大值
// 那么要比这个值刚好大一点，则需要进位，而进的位则正好是比当前这个位置的数字大一点的数字
// 我们通过二分也好，循环也好查找到这个数字，然后将这个数字和我们当前位置的数字进行交换
// 交换完成之后（也就是进位完成），我们当前位置（也即是最高位）已经变大了，
// 那么相应的，右边就要变成非递减排列，来保证右边是最小值，这样才刚刚好比我们变换前的大一点
// 所有的操作完成之后，我们就得到了这个数字，而当前位置左边的数字我们不需要变化
// 最后我们判断一下如果我们没有做任何的变化，那就返回"no answer"，如果有变化，那就返回变化后的即可
// AC
fun biggerIsGreater(w: String): String {
    val n = w.length
    val arr = w.toCharArray()
    for (i in n - 2 downTo 0) {
        if (w[i] < w[i + 1]) {
            var toSwapAt = n - 1
            while (toSwapAt > i && w[toSwapAt] <= w[i]) toSwapAt -= 1
            arr[i] = w[toSwapAt]
            arr[toSwapAt] = w[i]
            var lo = i + 1
            var hi = n - 1
            while (lo < hi) {
                val temp = arr[lo]
                arr[lo] = arr[hi]
                arr[hi] = temp
                lo += 1
                hi -= 1
            }
            break
        }
    }
    val answer = String(arr)
    return if (answer == w) "no answer" else answer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val T = scan.nextLine().trim().toInt()
    for (TItr in 1..T) {
        val w = scan.nextLine()
        val result = biggerIsGreater(w)
        println(result)
    }
}
