package practice.algorithms.strings.easy

import java.util.*

// Complete the superReducedString function below.
fun superReducedString(s: String): String {
    // 方法1
    // 利用栈的后进先出的特点来删除相邻的相同字符
    // Passed
    val stack = Stack<Char>()
    for (ch in s) {
        if (stack.isEmpty()) {
            stack.push(ch)
        } else {
            if (ch == stack.peek()) stack.pop()
            else stack.push(ch)
        }
    }
    val sb = StringBuilder()
    for (ch in stack) sb.append(ch)
    return if (sb.isEmpty()) "Empty String" else sb.toString()
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = superReducedString(s)

    println(result)
}
