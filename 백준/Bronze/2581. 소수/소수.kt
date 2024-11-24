fun getPrime(a: Int, b: Int): List<Int> {
    val primes = mutableListOf<Int>()

    for (i in a..b) {
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
    val m = readln().toInt()
    val n = readln().toInt()

    val prime = getPrime(m, n)

    if (prime.isEmpty()) {
        println(-1)
    } else {
        println(prime.sum())
        println(prime[0])
    }
}
