class Solution {
    // terms: 약관 종류, 유효 기간 / privacies: 날짜, 약관 종류
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val answer = mutableListOf<Int>()
        val todayDays = getDays(today)
        val termMap = terms.associate { term ->
            term.split(" ").let { it[0] to it[1].toInt() * 28 }
        } // 약관 to 기간

        for ((num, privacy) in privacies.withIndex()) {
            val (rawDate, clause) = privacy.split(" ")
            val contractDays = getDays(rawDate)
            val expireDays = contractDays + termMap[clause]!! - 1
            
            if (expireDays < todayDays) answer.add(num + 1)
        }

        return answer.toIntArray()
    }
    
    private fun getDays(date: String): Int {
        val (year, month, day) = date.split(".").map { it.toInt() }
        return year * 12 * 28 + month * 28 + day
    } 
}