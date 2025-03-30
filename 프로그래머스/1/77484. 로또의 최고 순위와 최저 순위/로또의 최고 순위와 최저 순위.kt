class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {        
        val winCount = lottos.count { it in win_nums }
        val possibleCount = lottos.count { it == 0 }
        
        val answer = IntArray(2).apply {
            this[0] = prizeLotto(winCount, possibleCount)
            this[1] = prizeLotto(winCount)
        }
        
        return answer
    }
    
    private fun prizeLotto(base: Int, add: Int = 0): Int {
        val total = base + add
        return when (total) {
            6 -> 1
            5 -> 2
            4 -> 3
            3 -> 4
            2 -> 5
            else -> 6
        }
    }
}