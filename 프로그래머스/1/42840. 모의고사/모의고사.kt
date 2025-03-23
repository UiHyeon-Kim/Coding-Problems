class Solution {
    fun solution(answers: IntArray): IntArray {
        val supo1 = listOf(1,2,3,4,5)
        val supo2 = listOf(2,1,2,3,2,4,2,5)
        val supo3 = listOf(3,3,1,1,2,2,4,4,5,5)
        val result = IntArray(3)
        
        answers.forEachIndexed { index, num ->
            if (num == supo1[index % supo1.size]) result[0]++
            if (num == supo2[index % supo2.size]) result[1]++
            if (num == supo3[index % supo3.size]) result[2]++
        }
        
        val maxValue = result.maxOrNull() ?: -1
        
        return result.indices.filter { result[it] == maxValue }.map { it + 1 }.toIntArray()
    }
}