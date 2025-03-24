class Solution {
    fun solution(k: Int, m: Int, score: IntArray) = score.sortedDescending().chunked(m).map { if (it.size == m) it[m-1] * m else 0 }.sum()
}