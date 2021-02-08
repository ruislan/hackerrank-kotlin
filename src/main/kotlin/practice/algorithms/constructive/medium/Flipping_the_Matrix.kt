package practice.algorithms.constructive.medium

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val n = readLine()!!.trim().toInt()
        val matrix = Array(2 * n) { Array(2 * n) { 0 } }
        for (i in 0 until 2 * n) {
            matrix[i] = readLine()!!.split(" ").map { it.trim().toInt() }.toTypedArray()
        }

        // 方法1
        // 通过观察可以知道，我们只需要检查四个点，左上，右上，左下，右下
        // 这四个点中最大的那个就是我们需要的
        // 而检查的范围只需要是0 until n，这个范围在原二维数组里面只有4个点的左上
        // 我们通过2 * n - row/col - 1分别求出右上，左下，右下
        // 最后加上这些最大的点就是结果
        // AC
        var answer = 0
        for (row in 0 until n) {
            for (col in 0 until n) {
                var max = Math.max(matrix[row][col], matrix[row][2 * n - col - 1])
                max = Math.max(max, matrix[2 * n - row - 1][col])
                max = Math.max(max, matrix[2 * n - row - 1][2 * n - col - 1])
                answer += max
            }
        }

        println(answer)
    }
}
