class Solution {
    fun solution(arr: Array<IntArray>): Array<IntArray> {
        var answer = arr
        
        val column = arr.size
        val row = arr[0].size
        
        if (column > row) {
            val a = IntArray(column - row) { 0 }
             answer.forEachIndexed { index, el ->
                 answer[index] = el + a
             }
        } else if (column < row) {
            val a = IntArray(row) { 0 }
            while(answer.size != row) {
                answer += a
            }
        }
        
        return answer
    }
}