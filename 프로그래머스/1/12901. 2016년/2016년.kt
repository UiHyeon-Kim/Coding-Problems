class Solution {
    fun solution(a: Int, b: Int): String {
        val dayOfMonth = listOf(0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        var totalDay = dayOfMonth.take(a).fold(b) { acc, day -> acc + day }
        
        var answer = when(totalDay % 7) {
            0 -> "THU"
            1 -> "FRI"
            2 -> "SAT"
            3 -> "SUN"
            4 -> "MON"
            5 -> "TUE"
            else -> "WED"
        }
        
        return answer
    }
}