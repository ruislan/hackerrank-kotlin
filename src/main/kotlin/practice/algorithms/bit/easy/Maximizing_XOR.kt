package practice.algorithms.bit.easy

fun main(args: Array<String>) {
    val l = readLine()!!.trim().toInt()
    val r = readLine()!!.trim().toInt()

    // 方法1
    // 这个没啥好说的，暴力尝试所有的可能就行了
    var answer = 0
    for (x in l..r) {
        for (y in l..r) {
            answer = kotlin.math.max(answer, x xor y)
        }
    }
    println(answer)
}
