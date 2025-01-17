fun main() {
    val stairs = readln().toInt()
    val point = IntArray(stairs + 1)
    val dp = IntArray(stairs + 1)

    for (index in 1..stairs) point[index] = readln().toInt()

    if (stairs == 1) {
        println(point[1])
        return
    }
    dp[1] = point[1]
    dp[2] = point[1] + point[2]

    for (step in 3..stairs) {
        dp[step] = maxOf(dp[step - 2] + point[step], dp[step - 3] + point[step - 1] + point[step])
    }

    println(dp[stairs])
}
