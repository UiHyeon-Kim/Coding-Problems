fun main() {
    val k = readln().toInt()
    val inorder = readln().split(" ").map { it.toInt() }
    val result = Array(k) { mutableListOf<Int>() }

    fun division(array: List<Int>, depth: Int) {
        if (depth == k) return
        val mid = array.size / 2

        result[depth].add(array[mid])

        division(array.subList(0, mid) , depth + 1)
        division(array.subList(mid + 1, array.size), depth + 1)
    }

    division(inorder, 0)

    for (i in 0 until k) {
        println(result[i].joinToString(" "))
    }
}