fun main() {
    var n = readln().toInt()
    var count = 0

    while (n > 0) {
        if (n % 5 == 0) {
            count += n / 5
            n %= 5
            break
        }
        n -= 3
        count++
    }
    if (n != 0) println(-1) else println(count)
}
