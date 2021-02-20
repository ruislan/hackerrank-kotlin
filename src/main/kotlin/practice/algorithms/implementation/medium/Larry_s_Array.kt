package practice.algorithms.implementation.medium

import java.util.*

// 方法1
// 暴力法
// 因为数据量不大，只有1000，暴力法应该可以
// 已知转换的方式是，向左移动数组，且只能是3个元素一组
// 也即是说只有三种变形 ABC -> BCA -> CAB -> ABC
// 迭代数组
//    当前数字在正确的位置上就继续
//    检查当前是否是最后两位数字，因为最后两位数字已经没办法再继续变形了
//       如果是最后两位数字之一，则返回"NO"
//    然后在i+1处到最后n-1搜索正确的数字x，记录下它的位置为j
//    接着，我们要放到正确的位置，所以我们只要还没到当前位置i和i+2处
//    （也就是包含当前位置的可移动范围），我们就最大限度的变形，也
//    即是j - 2开始到j，然后变形两次，x就到了这个范围的最左边
//    然后j-=2,重复直到进入i..i+2处，然后移动j - i次即可移动到正确的位置上
// AC
fun solution1(arr: Array<Int>, n: Int): String {
    for (i in 0 until n) {
        if (arr[i] == i + 1) continue
        if (n - i < 3) return "NO"
        var j = i + 1
        while (arr[j] != i + 1) j += 1
        while (j - i > 2) {
            rotate(arr, j - 2)
            rotate(arr, j - 2)
            j -= 2
        }
        while (j - i > 0) {
            rotate(arr, i)
            j -= 1
        }
    }
    return "YES"
}

fun rotate(arr: Array<Int>, i: Int) {
    val first = arr[i]
    arr[i] = arr[i + 1]
    arr[i + 1] = arr[i + 2]
    arr[i + 2] = first
}

// 方法2
// 其实这道题的考点在奇偶性验证，为什么这么说呢？
// 我们观察一下最简单的三个数字，123，
// 123：显然123有序，那么他们不用移动
// 312：这里我们可以看到1和2虽然不在正确的位置上，但是他们的相对位置是正确的
//     而3离它正确的位置的距离是2，我们可以通过左移1位就得到结果123
// 213：这里我们可以看到2的相对位置不对，而1和3或者2和3的相对位置是正确的，那么2
//     离它的位置距离是1，这里我们无论怎么移动都得不到结果
// 321: 3不对，2不对，3的距离是2，而2的距离是1，也就是总共要移动的距离是3，这里
//     我们无论怎么移动也不得不到结果
// 所以，这里我们看出来了一个规律，只要移动的距离能够被2整除就是可以的，否则是不行的
// 而我们需要怎么来统计这个移动的总的距离呢，通过上面我们可以看到，
// 只需要统计每个数字的右边所有数字比它小的，都是要移动的，找到一个就+1
// 最后统计所有的数字的移动距离就可以得到总距离，然后判断奇偶性就可以了
// AC
fun solution2(arr: Array<Int>, n: Int): String {
    var count = 0
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (arr[i] > arr[j]) count += 1
        }
    }
    return if ((count and 1) == 0) "YES" else "NO"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val t = scan.nextLine().trim().toInt()
    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()
        val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
        val result = solution2(arr, n)
        println(result)
    }
}
