class Solution {
    fun solution(places: Array<Array<String>>): IntArray {
        var answer = mutableListOf<Int>()
        
        for (rawPlace in places) {
            val place = rawPlace.map { it.toCharArray() }.toTypedArray()
            var pass = true
            
            loop@for (row in 0 until rawPlace.size) {    // 한 줄 
                for (col in place.indices) {        // 한 글자
                    if (place[row][col] == 'P') pass = bfs(place, row to col)
                    if (!pass) break@loop
                }
            }
            
            answer.add(if (pass) 1 else 0)
        }
        
        return answer.toIntArray()
    }
    
    fun bfs(place: Array<CharArray>, p: Pair<Int, Int>): Boolean {
        val q = ArrayDeque<Pair<Int, Int>>()
        val dist = Array(5) { IntArray(5) { -1 } }
        val direction = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

        q.add(p)
        dist[p.first][p.second] = 0
        
        while (q.isNotEmpty()) {
            val (cx, cy) = q.removeFirst()
            
            for ((dx, dy) in direction) {
                val nx = cx + dx
                val ny = cy + dy
                
                // 범위내가 아니고, 파티션이고, 2거리 이상이면 패스
                if (nx !in 0 until 5 || ny !in 0 until 5 || place[nx][ny] == 'X' || dist[nx][ny] != -1 || dist[cx][cy] >= 2) continue
                if (place[nx][ny] == 'P') return false
                q.add(nx to ny)
                dist[nx][ny] = dist[cx][cy] + 1 
            }
        }
        
        return true
    }
}