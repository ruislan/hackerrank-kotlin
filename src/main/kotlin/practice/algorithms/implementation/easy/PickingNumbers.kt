package practice.algorithms.implementation.easy

/*
 * Complete the 'pickingNumbers' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY a as parameter.
 */

fun pickingNumbers(a: Array<Int>): Int {
    // 方法1
    // 排序之后从低到高统计，如果差距大于0的重新统计，找出最大的
    // Passed
//    a.sort()
//    var answer = 0
//    var count = 1
//    for (i in 1 until a.size) {
//        if (Math.abs(a[i] - a[i - 1]) <= 1) {
//            count += 1
//            a[i] = a[i - 1]
//        } else count = 1
//        answer = Math.max(answer, count)
//    }
//    return answer

    // 方法2
    // 因为总共只有100个数字（从1开始的，所以要算上0一共101），
    // 统计数组的每个数字的频率
    // 然后找出freq[i] + freq[i - 1]最大的那个就是最大值
    // Passed
    val freq = IntArray(101)
    a.forEach { freq[it] += 1 }
    var answer = 0
    (1 until 101).forEach { answer = Math.max(answer, freq[it] + freq[it - 1]) }
    return answer
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val a = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = pickingNumbers(a)

    println(result)
}
