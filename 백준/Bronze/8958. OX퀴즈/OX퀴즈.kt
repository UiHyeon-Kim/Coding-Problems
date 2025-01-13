fun main() {
    repeat(readln().toInt()) {
        val ox = readlnOrNull()
        var sum = 0
        var count = 0

        for (i in ox!!) {
            if (i == 'O') sum += ++count
            else count = 0
        }

        println(sum)
    }
}
