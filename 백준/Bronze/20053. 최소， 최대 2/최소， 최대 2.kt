fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val nums = readln().split(" ").map { it.toInt() }
        println("${nums.min()} ${nums.max()}")
    }
}
