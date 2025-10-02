fun main() {
    val n = readln().toInt()
    val nums = readln().split(" ").map { it.toInt() }
    val operators = readln().split(" ").map { it.toInt() } // + - * /
    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE

    fun backtrack(depth: Int, sum: Int, plus: Int, minus: Int, mul: Int, div: Int) {
        if (depth == n) {
            max = max.coerceAtLeast(sum)
            min = min.coerceAtMost(sum)
            return
        }

        if (plus > 0) backtrack(depth + 1, sum + nums[depth], plus - 1, minus, mul, div)
        if (minus > 0) backtrack(depth + 1, sum - nums[depth], plus, minus - 1, mul, div)
        if (mul > 0) backtrack(depth + 1, sum * nums[depth], plus, minus, mul - 1, div)
        if (div > 0) backtrack(depth + 1, sum / nums[depth], plus, minus, mul, div - 1)
    }

    backtrack(1, nums[0], operators[0], operators[1], operators[2], operators[3])

    println(max)
    println(min)
}
