class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer = mutableSetOf<Int>()
        
        for (i in numbers.indices) {
            for (j in i..numbers.size - 1) {
                if (i != j) answer.add(numbers[i] + numbers[j])
            }
        }
                
        return answer.sorted().toIntArray()
    }
}