import java.util.PriorityQueue

class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val graph = Array(N + 1) { mutableListOf<Pair<Int, Int>>() } // 마을 = 연결된 마을 to 가중치
        val dist = IntArray(N + 1) { Int.MAX_VALUE } // 각 마을까지 거리
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }) // 노드 to 거리

        for ((node1, node2, weight) in road) {
            graph[node1].add(node2 to weight)
            graph[node2].add(node1 to weight)
        }

        dist[1] = 0
        pq.add(1 to 0)

        while (pq.isNotEmpty()) {
            val (node, currentDist) = pq.poll()
            if (currentDist > dist[node]) continue

            for ((neighbor, weight) in graph[node]) {
                val total = currentDist + weight
                if (dist[neighbor] > total) {
                    dist[neighbor] = total
                    pq.offer(neighbor to total)
                }
            }
        }

        return dist.count { it <= k }
    }
}