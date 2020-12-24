package practice.algorithms.strings.easy

import java.util.*

// Complete the beautifulBinaryString function below.
fun beautifulBinaryString(b: String): Int {
    // 方法1
    // 我们只需要找到多少个010，就知道要改多少次
    // 因为我们总是可以修改010中的最后一个0为1
    // 这样就总是出现11并列在中间的情况，后面不管是00，01，10，11都不会有010了
    // Passed
//    var answer = 0
//    var str = b
//    while (str.length > 2) {
//        val i = str.indexOf("010")
//        if (i > -1) answer += 1
//        str = str.substring(i + 3)
//    }
//    return answer

    // 方法2
    // 只是找010的方式有所不同
    // 不用创建那么多个字符串
    // Passed
    var i = 0
    var answer = 0
    while (i < b.length - 2) {
        if (b[i] == '0' && b[i + 1] == '1' && b[i + 2] == '0') {
            answer += 1
            i += 2
        }
        i += 1
    }
    return answer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val b = scan.nextLine()

    val result = beautifulBinaryString(b)

    println(result)
}
