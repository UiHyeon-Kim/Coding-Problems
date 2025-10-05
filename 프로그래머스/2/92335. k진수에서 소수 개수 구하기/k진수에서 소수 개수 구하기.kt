class Solution {
    fun solution(n: Int, k: Int): Int = n.toString(k)
        .split("0")
        .filter { it.isNotEmpty() }
        .map { it.toLong() }
        .count { isPrime(it) }
        
    private fun isPrime(num: Long): Boolean {
        if (num < 2) return false
        if (num == 2L) return true
        if (num % 2 == 0L) return false

        for (i in 3..Math.sqrt(num.toDouble()).toInt() step 2) {
            if (num % i == 0L) return false
        }

        return true
    }
}