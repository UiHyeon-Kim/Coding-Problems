fun getPrime(num: Long): Long {
    var prime = 0L

    for (i in num..num + 1000) {
        if (i < 2) continue
        if (i == 2L || i == 3L) {
            prime = i
            break
        }
        if (i % 2 == 0L || i % 3 == 0L) continue
        var isPrime = true
        for (j in 5..Math.sqrt(i.toDouble()).toInt() step 2) {
            if (i % j == 0L) {
                isPrime = false
                break
            }
        }
        if (isPrime) {
            prime = i
            break
        }
    }
    return prime
}

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toLong()
        println(getPrime(n))
    }
}
