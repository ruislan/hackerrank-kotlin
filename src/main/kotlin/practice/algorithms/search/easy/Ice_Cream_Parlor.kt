package practice.algorithms.search.easy


import java.util.*
import kotlin.collections.HashMap
import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {
    // 方法1
    // 注意利用题目说的每组数据都有唯一解
    // 利用hashmap存储所有的数据
    // 然后通过找到m - arr[i]再hashmap中的数据来检查是否是符合条件的
    // 注意相同的数字，类似2 + 2 = 4这样的情况，要检查hashmap中的是不是同样的
    // Passed
    val scan = Scanner(System.`in`)
    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val m = scan.nextLine().trim().toInt()
        val n = scan.nextLine().trim().toInt()
        val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

        val hashmap = HashMap<Int, ArrayList<Int>>()
        for (i in arr.indices) {
            if (hashmap[arr[i]] == null) hashmap[arr[i]] = ArrayList()
            hashmap[arr[i]]!!.add(i)
        }

        printPair(arr, hashmap, m)
    }
}

fun printPair(arr: Array<Int>, hashmap: HashMap<Int, ArrayList<Int>>, m: Int) {
    for (i in arr.indices) {
        val x = arr[i]
        val y = m - x
        val item = hashmap[y]
        if (item != null) {
            if (x == y) {
                for (j in item) {
                    if (j != i) {
                        println("${min(i + 1, j + 1)} ${max(i + 1, j + 1)}")
                        return
                    }
                }
            } else {
                println("${min(i + 1, item[0] + 1)} ${max(i + 1, item[0] + 1)}")
                return
            }
        }
    }
}
