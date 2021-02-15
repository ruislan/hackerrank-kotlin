package practice.algorithms.search.medium

// https://www.hackerrank.com/challenges/minimum-loss/problem

// 方法1
// 将Price带着index按照从大到小的顺序排序
// 然后判断当前数字后面的数字如果它原顺序比当前数字要靠后
// 并且它的值要比原数字要小，那么就纳入参考
// 最后得出相差最小的那个
// 由于其O(n^2)的复杂度，在n处于较低数量级的时候可以解决
// 也即是其subtasks完成
// 通过率11/16，未通过的全部是TLE
fun solution1(price: Array<Long>): Int {
    val n = price.size
    val prices = mutableListOf<Pair<Int, Long>>()
    for (i in 0 until n) {
        prices.add(Pair(i, price[i]))
    }
    prices.sortByDescending { it.second }
    var answer = Long.MAX_VALUE
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (prices[i].first < prices[j].first && prices[i].second > prices[j].second) {
                answer = Math.min(answer, prices[i].second - prices[j].second)
            }
        }
    }
    return answer.toInt()
}

// 方法2
// 方法1的优化
// 其实我们不用O(n^2),用O(nlogn)即可解决，
// 当然忽略排序的时间复杂度，O(n)就可以解决
// 我们在方法1将当前数字后面所有符合条件的都比了一下
// 其实完全没有必要嘛，因为越往后，数字越小，所以我们
// 第一个改进，实际上是找到第一个就可以break了
// 但是这还是O(n^2)，既然想到这里了，我们还可以再进一步
// 想想贪心算法中求两个数字之间的最小差值，
// 我们可以知道倒排之后求相邻两个数字的差值的最小就可以了
// 这里也是一样的，因为如果数字相隔得越远，差值肯定越大
// 既然这里一定有一个解，那这个解就在相邻两个数字中
// AC
fun solution2(price: Array<Long>): Int {
    val n = price.size
    val prices = mutableListOf<Pair<Int, Long>>()
    for (i in 0 until n) {
        prices.add(Pair(i, price[i]))
    }
    prices.sortByDescending { it.second }
    var answer = Long.MAX_VALUE
    for (i in 1 until n) {
        if (prices[i - 1].first < prices[i].first) {
            answer = Math.min(answer, prices[i - 1].second - prices[i].second)
        }
    }
    return answer.toInt()
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()
    val price = readLine()!!.split(" ").map { it.trim().toLong() }.toTypedArray()
    val result = solution2(price)

    println(result)
}
