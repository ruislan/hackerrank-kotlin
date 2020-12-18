package practice.algorithms.strings.easy

import java.util.*

// Complete the pangrams function below.
fun pangrams(s: String): String {
    val alphabets = IntArray(26)
    for (x in s) {
        if (x.isLetter()) alphabets[x.toLowerCase() - 'a'] += 1
    }
    for (x in alphabets) {
        if (x == 0) return "not pangram"
    }
    return "pangram"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = pangrams(s)

    println(result)
}
