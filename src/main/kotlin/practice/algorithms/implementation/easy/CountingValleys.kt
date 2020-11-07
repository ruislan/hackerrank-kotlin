package practice.algorithms.implementation.easy

/*
 * Complete the 'countingValleys' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER steps
 *  2. STRING path
 */
fun countingValleys(steps: Int, path: String): Int {
    // 方法1
    // 记录两个高度，当前高度altitude和前一个高度lastAltitude
    // 解析并迭代path，如果是U则altitude + 1，如果是D则 - 1
    // 如果lastAltitude是小于0的，而altitude == 0：
    //    则说明我们从山谷来到了海平面，则结果增加1
    // 将lastAltitude = altitude
    // Passed
//    var altitude = 0
//    var lastAltitude = altitude
//    var answer = 0
//    path.toCharArray().forEach {
//        if (it == 'U') altitude += 1
//        else altitude -= 1
//        if (lastAltitude < 0 && altitude == 0) answer += 1
//        lastAltitude = altitude
//    }
//    return answer

    // 方法2
    // 更加简便的方法
    // 查看当前是爬山U，然后altitude == 0，则说明我们是爬到了海平面
    // 这样可以节省一个参数
    // Passed
    var altitude = 0
    var answer = 0
    path.toCharArray().forEach {
        altitude += if (it == 'U') 1 else -1
        if (altitude == 0 && it == 'U') answer += 1
    }
    return answer
}

fun main(args: Array<String>) {
    val steps = readLine()!!.trim().toInt()

    val path = readLine()!!

    val result = countingValleys(steps, path)

    println(result)
}
