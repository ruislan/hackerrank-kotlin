package practice.algorithms.implementation

// Complete the bonAppetit function below.
fun bonAppetit(bill: Array<Int>, k: Int, b: Int): Unit {
    // 方法1
    // 计算除了i = k以外的所有的数字的和sum，除以2，得到一个数字
    // 这个数字与b对比，如果相等则返回Bon Appetit
    // 如果大于这个数字，则返回这个数字 - B
    // Passed
    var sum = 0
    for (i in bill.indices) {
        if (i != k) sum += bill[i]
    }
    val actual = sum / 2;
    if (actual == b) println("Bon Appetit")
    else println("${b - actual}")
}

fun main(args: Array<String>) {
    val nk = readLine()!!.trimEnd().split(" ")

    val n = nk[0].toInt()

    val k = nk[1].toInt()

    val bill = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val b = readLine()!!.trim().toInt()

    bonAppetit(bill, k, b)
}
