class Solution {
    fun solution(arr: IntArray, k: Int): IntArray {
        var answer = IntArray(k) { -1 }
        var ar = arr.toSet().take(k).forEachIndexed { index, v -> answer[index] = v }
        return answer
    }
}