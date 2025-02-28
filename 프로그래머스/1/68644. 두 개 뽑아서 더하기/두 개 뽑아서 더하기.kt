class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer = mutableSetOf<Int>()
        
        for (i in numbers.indices) {
            for (j in numbers.indices) {
                if (i != j) answer.add(numbers[i] + numbers[j])
            }
        }
                
        return answer.sorted().toIntArray()
    }
}