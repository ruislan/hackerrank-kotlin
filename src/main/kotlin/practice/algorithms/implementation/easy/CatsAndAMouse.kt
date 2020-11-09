package practice.algorithms.implementation.easy

import java.util.*

// Complete the catAndMouse function below.
fun catAndMouse(x: Int, y: Int, z: Int): String {
    // 方法1
    // 只需要直到x和y各自到z的距离，谁的距离小谁先到达z
    // 距离计算公式则是 (x - z).abs()即可
    // Passed
    return when (Math.abs(x - z).compareTo(Math.abs(y - z))) {
        -1 -> "Cat A"
        1 -> "Cat B"
        else -> "Mouse C"
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val xyz = scan.nextLine().split(" ")

        val x = xyz[0].trim().toInt()

        val y = xyz[1].trim().toInt()

        val z = xyz[2].trim().toInt()

        val result = catAndMouse(x, y, z)

        println(result)
    }
}
