fun main() {
    val memberInfo = mutableListOf<Pair<Int, String>>()
    repeat(readln().toInt()) {
        val (age, name) = readln().split(" ")
        memberInfo.add(age.toInt() to name)
    }

    memberInfo.sortedBy { it.first }.forEach { println("${it.first} ${it.second}") }
}
