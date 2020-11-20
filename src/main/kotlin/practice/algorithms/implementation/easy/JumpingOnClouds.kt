package practice.algorithms.implementation.easy

import java.util.*

// Complete the jumpingOnClouds function below.
fun jumpingOnClouds(c: Array<Int>, k: Int): Int {
    var i = 0
    var energy = 100
    while (true) {
        i = (i + k) % c.size
        energy -= if (c[i] == 1) 3 else 1
        if (i == 0) break
    }
    return energy
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val c = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = jumpingOnClouds(c, k)

    println(result)
}
