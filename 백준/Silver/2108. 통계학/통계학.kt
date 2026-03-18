fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    var sum = 0L
    val count = IntArray(8001)

    val arr = IntArray(n) {
        val num = readLine().toInt()
        sum += num
        count[num + 4000]++
        num
    }
    arr.sort()

    sb.append("%.0f".format(sum.toDouble() / n).toInt()).append("\n")
    sb.append(arr[n / 2]).append("\n")

    var maxFrequency = 0
    for (num in count) {
        if (num > maxFrequency) maxFrequency = num
    }

    var mode = 0
    var second = false
    for (i in 0..8000) {
        if (count[i] == maxFrequency) {
            mode = i - 4000
            if (second) break
            second = true
        }
    }

    sb.append(mode).append("\n")
    sb.append(arr.last() - arr.first())

    println(sb)
}