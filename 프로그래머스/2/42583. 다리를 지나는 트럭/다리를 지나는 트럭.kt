import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var time = 1
        var idx = 1
        val q: Queue<Int> = LinkedList()
        
        q.offer(truck_weights[0])
        
        while(true) {
            if(q.sum() == 0) break
            if(q.size >= bridge_length) q.poll()
            
            if(idx < truck_weights.size && q.sum() + truck_weights[idx] <= weight) {
                q.offer(truck_weights[idx])
                idx++
            } else {
                q.offer(0)
            }
            time++
        }
        
        return time
    }
}