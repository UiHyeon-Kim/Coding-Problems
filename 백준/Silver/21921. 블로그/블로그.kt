fun main() {
    val br = System.`in`.bufferedReader()
    val (n, x) = br.readLine().split(" ").map { it.toInt() }
    val input = br.readLine().split(" ").map { it.toInt() }

    var sum = input.take(x).sum()
    var max = sum
    var count = 1

    for (index in x..<n) {
        sum = sum - input[index - x] + input[index]

        if (sum > max) {
            max = sum
            count = 1
        } else if (sum == max) {
            count++
        }
    }

    if (max == 0) {
        println("SAD")
    } else {
        println(max)
        println(count)
    }
}
