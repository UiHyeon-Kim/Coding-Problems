class Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer = 0
        val visited = BooleanArray(dungeons.size)

        fun backTrack(fatigue: Int, count: Int) {
            if (count > answer) answer = count

            for (idx in dungeons.indices) {
                val (reqFatigue, consume) = dungeons[idx]
                if (!visited[idx] && fatigue >= reqFatigue) {
                    visited[idx] = true
                    backTrack(fatigue - consume, count + 1)
                    visited[idx] = false
                }
            }
        }
        backTrack(k, 0)
        return answer
    }
}