fun main() {
    val s = readln().toLong()
    var min = 1L
    var max = s
    var answer = 0L

    while (min <= max) {
        val mid = (max + min) / 2
        val sum = mid * (mid + 1) / 2

        if (sum <= s) {
            answer = mid
            min = mid + 1
        } else {
            max = mid - 1
        }
    }

    println(answer)
}