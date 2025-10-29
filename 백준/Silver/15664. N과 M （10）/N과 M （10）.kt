fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val nums = readln().split(" ").map { it.toInt() }.sorted()
    val set = mutableSetOf<List<Int>>()
    val subset = mutableListOf<Int>()

    fun backtrack(start: Int) {
        if (subset.size == m) {
            set.add(subset.toList())
            return
        }

        for (i in start..<nums.size) {
            subset.add(nums[i])
            backtrack(i + 1)
            subset.removeLast()
        }
    }

    backtrack(0)
    set.forEach { println(it.joinToString(" ")) }
}
