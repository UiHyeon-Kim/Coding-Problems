fun main() {
    var next = 0
    var cnt = 4
    for (i in 0 until 3) {
        cnt--
        val input = readln()
        if (input.toIntOrNull() != null) {
            next = input.toInt() + cnt
            break
        }
    }
    if (next % 3 == 0 && next % 5 == 0) println("FizzBuzz")
    else if (next % 3 == 0 && next % 5 != 0) println("Fizz")
    else if (next % 3 != 0 && next % 5 == 0) println("Buzz")
    else println(next)
}