package practice.algorithms.bit.easy

fun main(args: Array<String>) {
    // 方法1
    // 直接模拟，不过没办法处理大数据
    // n in [0..10^15]
    // 太简单就不写代码了

    // 方法2
    // 通过观察可以看出来，如果相加和xor要相等
    // 那么直接统计该数字二进制有多少个0即可
    // 例如:5 = 101b 有1个0，那么101b + 010b = 111b = 7
    // 然后因为0与任何数字相加和xor都是那个数字，所以5有2个
    // 再如:4 = 100b 有2个0，那么100b + 1b/10b/11b，有3个
    // 然后加上0为4个
    // 所以直接用1向左移动x次，x就是n的二进制0的数量
    // n in [0..10^15]
    // Passed
    var n = readLine()!!.trim().toLong()
    var answer = 1L
    var zeros = 0
    while (n > 0) {
        if (n and 1 == 0L) {
            zeros += 1
        }
        n = n shr 1
    }
    answer = answer shl zeros
    println(answer)
}
