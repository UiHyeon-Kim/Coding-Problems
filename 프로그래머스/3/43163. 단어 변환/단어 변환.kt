class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = Int.MAX_VALUE
        val visited = BooleanArray(words.size)
        
        if (target !in words) return 0
        
        fun dfs(word: String, cnt: Int) {
            if (word == target) {
                answer = minOf(answer, cnt)
                return
            }
            
            for (wIdx in 0 until words.size) {
                if (!visited[wIdx]) {
                    var match = 0
                                
                    for (i in word.indices) {
                        if (word[i] != words[wIdx][i]) match++
                    }

                    if (match == 1) {
                        visited[wIdx] = true
                        dfs(words[wIdx], cnt + 1)
                        visited[wIdx] = false
                    }
                }
            }
        }
        
        dfs(begin, 0)
        
        return answer
    }
}