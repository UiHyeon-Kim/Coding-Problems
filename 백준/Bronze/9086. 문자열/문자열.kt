fun main() {
    val cnt = readln().toInt()

    repeat(cnt) {
        val word = readln()

        print(word.first())
        println(word.last())
    }
}