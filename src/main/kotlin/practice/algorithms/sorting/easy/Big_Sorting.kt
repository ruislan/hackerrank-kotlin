package practice.algorithms.sorting.easy

import java.util.*

// Complete the bigSorting function below.
// 这道题不得不吐槽一下
// 首先是我很快就直接用方法1完成了，但是testcase6报TLE（超时）
// 然后就用方法2试了一下，依然TLE
// 没办法了，看看discuss怎么说，
// 就看到一个大神说，我啥代码都没写，就看看testcase6给不给报错
// 结果依然报了个TLE，那说明题目的代码模板有问题啊，
// 然后发现问题就是Scanner用的nextLine， 换成next就可以了
// 然后我按照大神的说法替换成next，方法2就通过了
// 方法1和2都是一个量级的，又试了一下方法1，也通过了
// 真是不知道说啥了～～～，看来以后是要自己弄模板，不要官方模板了吗？
fun bigSorting(unsorted: Array<String>): Array<String> {
    // 方法1
    // 先按照len排序，然后按照字符串排序即可
    // Passed
    val map = unsorted.groupBy { it.length }.toSortedMap()
    return map.map {
        (it.value as MutableList).sort()
        it.value
    }.flatten().toTypedArray()

    // 方法2
    // 方法1的一次性写法
    // Passed
//    unsorted.sortWith(kotlin.Comparator { a,b ->
//        var cmp = a.length - b.length
//        if (cmp == 0) {
//            for (i in a.indices) {
//                val diff = a[i] - b[i]
//                if (diff != 0) {
//                    cmp = diff
//                    break
//                }
//            }
//        }
//        cmp
//    })
//    return unsorted
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val unsorted = Array<String>(n, { "" })
    for (i in 0 until n) {
        val unsortedItem = scan.next()
        unsorted[i] = unsortedItem
    }

    val result = bigSorting(unsorted)

    println(result.joinToString("\n"))
}
