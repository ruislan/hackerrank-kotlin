package practice.algorithms.strings.easy

import java.util.*

// Complete the caesarCipher function below.
fun caesarCipher(s: String, k: Int): String {
    // 方法1
    // 旋转一般都会用到"%"操作
    // 这里是英文字母才会转换，所以转换的分母是26
    // 然后需要注意的就是先要将ascii的'a'或'A'不是从0开始的
    // 所以要先将他们转成0，然后再英文字母转换之后，又要转回ascii
    // 所以是个两层转换
    // Passed
    val sb = StringBuilder()
    for (ch in s) {
        sb.append(
                if (ch.isLetter()) {
                    val base = if (ch.isUpperCase()) 'A' else 'a'
                    base + (ch - base + k) % 26
                } else {
                    ch
                }
        )
    }
    return sb.toString()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val k = scan.nextLine().trim().toInt()

    val result = caesarCipher(s, k)

    println(result)
}
