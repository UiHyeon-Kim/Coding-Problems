fun main() {
    repeat(readln().toInt()) {
        val str = readln().lowercase()
        val pangram = IntArray(26)

        for (ch in str) {
            if (ch in 'a'..'z') pangram[ch - 'a']++
        }

        val minCount = pangram.minOrNull() ?: 0

        val result = when {
            minCount == 0 -> "Not a pangram"
            minCount == 1 -> "Pangram!"
            minCount == 2 -> "Double pangram!!"
            else -> "Triple pangram!!!"
        }

        println("Case ${it + 1}: $result")
    }
}
