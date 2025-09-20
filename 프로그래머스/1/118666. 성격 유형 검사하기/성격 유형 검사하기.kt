class Solution {
    val result = mutableMapOf(
        'R' to 0, 'T' to 0,
        'C' to 0, 'F' to 0,
        'J' to 0, 'M' to 0,
        'A' to 0, 'N' to 0
    )
    
    fun solution(survey: Array<String>, choices: IntArray): String {
        for (i in choices.indices) {
            val score = Math.abs(choices[i] - 4)
            if (choices[i] < 4) result[survey[i][0]] = result[survey[i][0]]!! + score
            if (choices[i] > 4) result[survey[i][1]] = result[survey[i][1]]!! + score
        }
        
        print(result)
        return "${pick('R', 'T')}${pick('C', 'F')}${pick('J', 'M')}${pick('A', 'N')}"
    }
    
    fun pick(s1: Char, s2: Char): Char = if(result[s1]!! >= result[s2]!!) s1 else s2 
}