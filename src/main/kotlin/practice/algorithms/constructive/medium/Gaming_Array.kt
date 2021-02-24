package practice.algorithms.constructive.medium

import java.util.*
import kotlin.collections.*

// 方法1
// 利用大顶堆将所有数据存起来
// 利用HashSet将略过的所有数据存起来
// 从后向前迭代，当arr[i]等于堆顶时，弹出堆顶，
// 同时判断堆顶是否是在删除列表中，如果在删除列表中，则一直删除，直到不在删除列表中
// 一直到最后就可以判断谁是获胜的
// 时间复杂度在O(nlogn)
// AC 22/22
fun solution1(n: Int, arr: Array<Int>): String {
    val que = PriorityQueue<Int>(kotlin.Comparator { o1, o2 -> o2 - o1 })
    for (x in arr) que.add(x)
    var bob = false
    val removed = HashSet<Int>()
    for (i in n - 1 downTo 0) {
        if (arr[i] == que.peek()) {
            bob = !bob
            que.poll()
            while (removed.contains(que.peek())) que.poll()
        } else {
            removed.add(arr[i])
        }
    }
    return if (bob) "BOB" else "ANDY"
}

// 方法2
// 设置一个移动计数count
// 从前向后迭代数组，并将第一个值作为最大值，并将计数增加1
// 当出现一个数字比最大值还要大，则继续计数加1，并将最大值切换为这个
// 最后移动总数 % 2，如果有余数，则说明bob赢了，而没有则是Andy
// 因为只有两个人参赛，而Bob总是第一个移动，所以他是奇数
// 时间复杂度是O(n)
//
fun solution2(n: Int, arr: Array<Int>): String {
    var count = 0
    var max = 0
    for (x in arr) {
        if (x > max) {
            max = x
            count += 1
        }
    }
    return if ((count and 1) == 1) "BOB" else "ANDY"
}

fun main(args: Array<String>) {
    val g = readLine()!!.trim().toInt()
    for (gItr in 1..g) {
        val n = readLine()!!.trim().toInt()
        val arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
        val result = solution2(n, arr)
        println(result)
    }
}

