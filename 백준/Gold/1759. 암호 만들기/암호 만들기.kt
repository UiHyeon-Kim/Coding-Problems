fun main() {
    val (l, _) = readln().split(" ").map { it.toInt() }
    val alphabet = readln().split(" ").sorted()

    print(combination(alphabet, l))
}

private fun combination(alphabet: List<String>, len: Int): String {
    val sb = StringBuilder()
    val subset = mutableListOf<String>()

    fun dfs(start: Int) {
        if (isValid(subset, len)) {
            subset.forEach { sb.append(it) }
            sb.append("\n")
            return
        }

        for (i in start until alphabet.size) {
            subset.add(alphabet[i])
            dfs(i + 1)
            subset.removeLast()
        }
    }

    dfs(0)
    return sb.toString()
}

private fun isValid(subset: MutableList<String>, len: Int): Boolean {
    val vowel = setOf("a", "e", "i", "o", "u")
    return subset.size == len &&
            subset.any { it in vowel } &&
            subset.filterNot { it in vowel }.count() >= 2
}