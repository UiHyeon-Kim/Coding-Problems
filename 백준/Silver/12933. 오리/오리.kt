fun main() {
    val str = readln()
    val ducks = mutableListOf<StringBuilder>()
    val cry = ("quack").withIndex().associate { it.value to it.index }

    loop@ for (c in str) {
        val currentIndex = cry[c]!!

        for (duck in ducks) {
            if (duck.length % 5 == currentIndex) {
                duck.append(c)
                continue@loop
            }
        }

        ducks.add(StringBuilder().append(c))
    }

    val count = if (ducks.any { it.length % 5 != 0 }) -1 else ducks.size
    println(count)
}