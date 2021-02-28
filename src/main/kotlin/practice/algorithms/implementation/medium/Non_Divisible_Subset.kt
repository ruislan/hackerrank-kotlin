package practice.algorithms.implementation.medium

// 方法1
// 这个题需要一些技巧，我不知道怎么锻炼能够解决发现这个技巧的过程，只能说多练吧，唯手熟尔。
// 1. (a + b) % k == 0 可以分解成 a % k + b % k == 0，这样我们可以求出所有的remainder
//    然后放入一个长度为k的数组，数组的下标就是remainder，例如1 7 2 4 k=3,remainder[0 3 1]
// 2. 我们忽略掉第0的下标，remainder的下标对位正好就是(a + b) % k == 0的情况，而这个情况下
//    我们只能二选一，因为两个选进来就不满足条件了，而既然我们要最多的subset，那我们就选freq最大的
// 3. 现在来处理忽略掉的第0个下标，因为有这样的情况，例如1 3 2 4 k = 3，remainder[1 2 1]
//    就是有数字能够直接被整除，那这个时候我们不能直接取它的频率，为什么呢？因为假设他有两个，为3和6
//    那么我们都放进来就意味着3 + 6必然能够被3整除，所以remainder = 0的freq再多，我们都只能要1个
// 4. 最后一个小细节，就是如果k % 2 == 0，那么就意味着我们中间有一个数字的对位正好是自己，而他正好是k的一半
//    所以，也只能要1个（为啥？因为k / 2 + k / 2正好等于k啊！！）
// AC
fun nonDivisibleSubset(k: Int, s: Array<Int>): Int {
    val remainderFreq = IntArray(k)
    for (x in s) remainderFreq[x % k] += 1
    var answer = if (remainderFreq[0] > 0) 1 else 0
    for (i in 1..k / 2) {
        answer += if (i != k - i) {
            Math.max(remainderFreq[i], remainderFreq[k - i])
        } else {
            1
        }
    }
    return answer
}

fun main(args: Array<String>) {
    val firstMultipleInput = readLine()!!.trimEnd().split(" ")
    val n = firstMultipleInput[0].toInt()
    val k = firstMultipleInput[1].toInt()
    val s = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    val result = nonDivisibleSubset(k, s)
    println(result)
}
