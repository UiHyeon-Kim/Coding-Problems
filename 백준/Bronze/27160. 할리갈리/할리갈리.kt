fun main() {
    val n = readln().toInt()
    val fruits = mutableMapOf("STRAWBERRY" to 0, "BANANA" to 0, "LIME" to 0, "PLUM" to 0)

    repeat(n) {
        val (fruit, num) = readln().split(" ")
        fruits[fruit] = fruits.getOrDefault(fruit, 0) + num.toInt()
    }

    var result = "NO"
    fruits.forEach {fruit, num -> if (num == 5) result = "YES" }
    println(result)
}