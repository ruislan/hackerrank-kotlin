package practice.algorithms.bit.easy

@ExperimentalUnsignedTypes
fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    // 方法1
    // 直接用UInt和inv()方法就可以了
    // AC
//    for (qItr in 1..q) {
//        val n = readLine()!!.trim().toUInt()
//        println(n.inv())
//    }

    // 方法2
    // 假设类似Java没有UInt
    // 那么我们需要转换成Long
    // 然后用Long翻转inv()
    // 然后把高32位给截断即可
    // AC
    for (qItr in 1..q) {
        val n = readLine()!!.trim().toLong()
        println(n.inv() and 0xFFFFFFFFL)
    }
}
