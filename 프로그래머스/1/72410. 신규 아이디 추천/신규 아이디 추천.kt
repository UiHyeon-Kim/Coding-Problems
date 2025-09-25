class Solution {
    fun solution(new_id: String): String = new_id.lowercase() // 1
            .replace(Regex("[^0-9a-z-_.]"), "") // 2
            .replace(Regex("\\.+"), ".") // 3
            .trim('.') // 4
            .let { if (it.isEmpty()) "a" else it } // 5
            .let { if (it.length > 15) it.substring(0, 15).trimEnd('.') else it } // 6
            .let { it.padEnd(3, it.last()) } // 7
}