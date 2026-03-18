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

    val frequencyMap = mutableMapOf<Int, Int>()
    for (num in arr) {
        frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
    }

    val maxValue = frequencyMap.maxBy { it.value }.value
    val key = frequencyMap.filter { maxValue == it.value }.keys.sorted()

    sb.append(if (key.size > 1) key[1] else key[0]).append("\n")
    sb.append(arr.last() - arr.first())

    println(sb)
}