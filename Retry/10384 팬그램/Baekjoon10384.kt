class Baekjoon10384 {

    private lateinit var alphabet: IntArray

    fun solve() {

        val repeatCount = readln().toInt()

        repeat(repeatCount) { sequence ->
            alphabet = IntArray(ALPHABET_LENGTH)

            val str = readln().lowercase()

            for (char in str) {
                if (char !in ALPHABET_RANGE.first..ALPHABET_RANGE.second) continue
                val index = getAlphabetIndex(char)
                alphabet[index]++
            }

            val minCount = alphabet.minOrNull() ?: 0

            println(printFormat(sequence + 1, minCount))
        }
    }

    companion object {
        const val ALPHABET_LENGTH = 26
        const val SINGLE_PANGRAM = "Pangram!"
        const val DOUBLE_PANGRAM = "Double pangram!!"
        const val TRIPLE_PANGRAM = "Triple pangram!!!"
        const val NOT_PANGRAM = "Not a pangram"

        val ALPHABET_RANGE = 'a' to 'z'

        fun getAlphabetIndex(char: Char) = char - 'a'
        fun printFormat(number: Int, minCount: Int): String {
            val word = when (minCount) {
                1 -> SINGLE_PANGRAM
                2 -> DOUBLE_PANGRAM
                3 -> TRIPLE_PANGRAM
                else -> NOT_PANGRAM
            }

            return "Case $number: $word"
        }
    }
}

fun main() {
    Baekjoon10384().solve()
}
