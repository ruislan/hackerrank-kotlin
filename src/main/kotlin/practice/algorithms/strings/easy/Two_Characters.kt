package practice.algorithms.strings.easy

// Complete the alternate function below.
fun alternate(s: String): Int {
    // 方法1
    // 暴力法
    // 通过遍历所有两种char的组合来看符合条件的情况下长度最长的那一组
    // 检查是否符合条件，只需要遍历s，保留char1和char2
    // 然后看两个是否是相间的即可
    // Passed
    if (s.length < 2) return 0
    var answer = 0
    for (ch1 in 'a'..'z') {
        for (ch2 in ch1 + 1..'z') {
            var prev = '0'
            var len = 0
            for (x in s) {
                if (x == ch1 || x == ch2) {
                    if (prev == '0') {
                        prev = x
                    } else if (prev == x) {
                        len = 0
                        break
                    } else {
                        prev = x
                    }
                    len += 1
                }
            }
            answer = Math.max(len, answer)
        }
    }
    return answer
}

fun main(args: Array<String>) {
    val l = readLine()!!.trim().toInt()

    val s = readLine()!!

    val result = alternate(s)

    println(result)
}
