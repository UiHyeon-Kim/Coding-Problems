import java.util.*

class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var count = 0
        val visited = BooleanArray(n)
        
        fun dfs(com: Int) {
            visited[com] = true
            for(adj in computers[com].indices) {
                if(computers[com][adj] == 1 && !visited[adj]) {
                    dfs(adj)
                }
            }
        } 
        
        for(i in 0 until n) {
            if(!visited[i]) {
                count++
                dfs(i)
            }
        }
        
        return count
    }
}