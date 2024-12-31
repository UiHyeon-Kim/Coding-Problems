import java.util.*

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val q: Queue<Pair<Int, Int>> = LinkedList()
        
        priorities.mapIndexed { index, priority ->
            q.offer(Pair(priority, index))
        }
        
        while(q.isNotEmpty()) {
            val current = q.poll()
            if(q.any { it.first > current.first }) {
                q.offer(current)
            } else {
                answer++
                if(current.second == location) break
            }
        }
        return answer
    }
}