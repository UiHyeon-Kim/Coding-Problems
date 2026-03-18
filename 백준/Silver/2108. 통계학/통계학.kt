fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(n) { readLine().toInt() }.sorted()

    val result = arr.sum() / n.toDouble()

    println("%.0f".format(result).toInt())
    println(arr[n / 2])

    val frequencyMap = mutableMapOf<Int, Int>()
    for (num in arr) {
        frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
    }

    val maxValue = frequencyMap.maxBy { it.value }.value
    val key = frequencyMap.filter { maxValue == it.value }.keys.sorted()

    println(if (key.size > 1) key[1] else key[0])
    println(arr.last() - arr.first())
}