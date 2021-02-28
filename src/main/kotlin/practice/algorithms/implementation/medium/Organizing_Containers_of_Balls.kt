package practice.algorithms.implementation.medium

// 方法1
// 1. 从1种球1个框开始，如果装了多余1个种类，自然无法完成，
//    所以这里我们至少知道第2个事情，球种类和框的数量必须一样，
//    球本身的数量和框的数量不相关，1种球1个框，1个和100个没区别
// 2. 2种球2个框，假设每种球1个，那有3种方法，[（0）（1 1）]|[（1）（1）][（1 1）（0）]
//    这里我们注意到，如果球平均分配给两个框，就能完成，而球都在一个框就不行，
//    这里需要深度提炼一下，发现种类是[(1),(1)]的情况下，框的容量必须是[(1),(1)]才可以，
//    而不是[(0),(2)]或者[(2),(0)]，也即是框的容量和球的种类必须匹配。
// 那我们提出了这个假设之后，就来进行验证。 当然，我选择了写代码然后提交，然后范例通过，看起来是对的。
// 所以直接提交，就全部通过了，所以这个假设是成立的。
// AC
fun organizingContainers(container: Array<Array<Int>>): String {
    val rows = container.size
    val cols = container[0].size
    val amounts = (0 until rows).map { row -> (0 until cols).map { col -> container[row][col] }.sum() }.sorted()
    val types = (0 until cols).map { col -> (0 until rows).map { row -> container[row][col] }.sum() }.sorted()
    return if (amounts == types) "Possible" else "Impossible"
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val n = readLine()!!.trim().toInt()
        val container = Array(n) { Array(n) { 0 } }
        for (i in 0 until n) {
            container[i] = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
        }
        val result = organizingContainers(container)
        println(result)
    }
}
