package practice.algorithms.implementation.easy

import java.util.*

// Complete the howManyGames function below.
fun howManyGames(p: Int, d: Int, m: Int, s: Int): Int {
    // Return the number of games you can buy
    // 方法1
    // 记录当前的价格price，每次购买减去d，直到价格低于m取值m
    // 统计买的总数即可
    // Passed
    var answer = 0
    var price = p
    var money = s
    while (money >= price) {
        money -= price
        answer += 1
        price = Math.max(m, price - d)
    }
    return answer

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val pdms = scan.nextLine().split(" ")

    val p = pdms[0].trim().toInt()

    val d = pdms[1].trim().toInt()

    val m = pdms[2].trim().toInt()

    val s = pdms[3].trim().toInt()

    val answer = howManyGames(p, d, m, s)

    println(answer)
}
