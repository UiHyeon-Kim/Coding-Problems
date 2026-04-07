package `1753 최단경로`

import java.util.PriorityQueue
import java.util.StringTokenizer

class Baekjoon1753 {

    data class Node(val to: Int, val weight: Int)

    private lateinit var graph: Array<ArrayList<Node>>
    private lateinit var dist: IntArray

    fun solve() = with(System.`in`.bufferedReader()) {
        var st = StringTokenizer(readLine())
        val V = st.nextToken().toInt()
        val E = st.nextToken().toInt()
        val K = readLine().toInt()

        graph = Array(V + 1) { ArrayList() }
        dist = IntArray(V + 1) { Int.MAX_VALUE }
        val sb = StringBuilder()

        repeat(E) {
            st = StringTokenizer(readLine())
            val u = st.nextToken().toInt()
            val v = st.nextToken().toInt()
            val w = st.nextToken().toInt()

            graph[u].add(Node(v, w))
        }
        bfs(K)

        for (i in 1..V) {
            sb.append(
                if (dist[i] == Int.MAX_VALUE) "INF" else dist[i]
            ).append("\n")
        }

        println(sb)
    }

    private fun bfs(k: Int) {

        val pq = PriorityQueue<Node>(compareBy { it.weight })

        pq.add(Node(k, 0))
        dist[k] = 0

        while (pq.isNotEmpty()) {
            val current = pq.poll()
            for (neighbor in graph[current.to]) {
                if (dist[neighbor.to] > current.weight + neighbor.weight) {
                    dist[neighbor.to] = current.weight + neighbor.weight
                    pq.add(Node(neighbor.to, current.weight + neighbor.weight))
                }
            }
        }
    }
}

fun main() {
    Baekjoon1753().solve()
}