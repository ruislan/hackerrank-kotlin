package practice.algorithms.implementation.easy

import java.util.*

// Complete the designerPdfViewer function below.
fun designerPdfViewer(h: Array<Int>, word: String): Int {
    // 方法1
    // 迭代word，在h中找出最高的那个字符tallest
    // 可以通过? - 'a' 直接得到h中的索引位置
    // 然后返回tallest * word.size
    return word.map { h[it - 'a'] }.max()!! * word.length
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val h = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val word = scan.nextLine()

    val result = designerPdfViewer(h, word)

    println(result)
}
