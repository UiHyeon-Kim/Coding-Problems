fun main() {
    var n = readln().toInt()
    var count = 0

    if (n % 5 == 0) {
        count = n / 5
    } else {
        count = n / 5
        n %= 5
        if (n % 2 == 0) {
            count += n / 2
        } else {
            if (count != 0) {
                count--
                n += 5
                count += n / 2
            } else {
                count = -1
            }
        }
    }

    println(count)
}
