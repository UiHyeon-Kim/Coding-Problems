class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        var listK = mutableListOf<Int>()
        
        for (i in score.indices) {
            listK.add(score[i])
            listK.sortDescending()
            
            if(listK.size < k) answer.add(listK.last())
            else answer.add(listK[k - 1])
        }
        
        return answer.toIntArray()
    }
}