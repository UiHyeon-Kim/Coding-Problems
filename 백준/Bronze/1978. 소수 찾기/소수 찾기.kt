fun getPrime(nums: List<Int>): List<Int> {
    val primes = mutableListOf<Int>()

    for (i in nums) {
        if (i < 2) continue
        if (i == 2 || i == 3) {
            primes.add(i)
            continue
        }
        if (i % 2 == 0 || i % 3 == 0) continue
        var isPrime = true
        for (j in 5..Math.sqrt(i.toDouble()).toInt() step 2) {
            if (i % j == 0) {
                isPrime = false
                break
            }
        }
        if (isPrime) primes.add(i)
    }
    return primes
}

fun main() {
    val n = readln().toInt()
    val input = readln().split(" ").map { it.toInt() }

    val primes = getPrime(input)

    println(primes.size)
}
