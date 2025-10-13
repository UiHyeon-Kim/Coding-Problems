fun main() {
    while (true) {
        val nums = readln()
            .also { if (it == "0") return }
            .split(" ")
            .drop(1)
            .map { it.toInt() }
            .sorted()

        permutation(nums).forEach {
            println(it.joinToString(" "))
        }
        println()
    }
}

private fun permutation(nums: List<Int>): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val subset = mutableListOf<Int>()
    val maxCount = 6

    fun dfs(depth: Int, start: Int) {
        if (depth == maxCount) {
            result.add(subset.toList())
            return
        }

        for (i in start until nums.size) {
            subset.add(nums[i])
            dfs(depth + 1, i + 1)
            subset.removeLast()
        }
    }

    dfs(0, 0)
    return result
}