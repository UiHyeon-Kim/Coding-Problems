class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var remainder = 0

        val sortedGroupStages = stages.sorted().groupBy { it / 1 }.filter { it.key in 1..N }
        val stageRate = sortedGroupStages.map { (k, v) -> 
            val previus = remainder
            remainder += v.size
            k to ((v.size.toDouble() / (stages.size - previus)) * 10)
        }.toMutableList()
        
        println(stageRate)
        
        for (i in 1..N) {
            if (i !in stageRate.map { it.first }) stageRate.add(i to 0.0)
        }
                  
        val answer = stageRate.sortedByDescending { it.second }.map { it.first }
        
        println(answer)
        
        return answer.toIntArray()
    }
}