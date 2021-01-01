package practice.algorithms.sorting.easy

import java.util.*

// Complete the insertionSort1 function below.
fun insertionSort1(n: Int, arr: Array<Int>) {
    // 方法1
    // 这个就是插入排序的一个部分环节
    // 也就是将一个数字插入到有序数组中去
    // 我们只需要向前遍历，如果再前一个比这个大，
    // 就将再前一个移动到当前这个索引
    // 如果都比这个大，那么最后将第一个位置的索引0设置为插入位置
    // 例如： 1 2 4 5 3
    //       1 2 4 5 5  // 5 > 3，移动5
    //       1 2 4 4 5  // 4 > 3，移动4
    //       1 2 3 4 5  // 2 < 3，将这个位置设置为3
    // 这里要说一下的是，我学习的插入排序是交换，并不是移动（shift）
    // 例如： 1 2 4 5 3
    //       1 2 4 3 5  // 5 > 3，交换
    //       1 2 3 4 5  // 4 > 3，交换
    //                  // 2 < 3，不变，结束
    // Passed
    val x = arr[arr.lastIndex]
    for (i in arr.lastIndex downTo 1) {
        if (arr[i - 1] > x) arr[i] = arr[i - 1]
        else arr[i] = x
        println(arr.joinToString(" "))
        if (arr[i] == x) return
    }
    arr[0] = x
    println(arr.joinToString(" "))
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    insertionSort1(n, arr)
}
