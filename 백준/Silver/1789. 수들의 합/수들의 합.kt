fun main() {
    val s = readln().toLong()
    var number = 1
    var sum = 1L

    while (s >= sum) {
        sum += ++number
    }

    println(number - 1)
}
