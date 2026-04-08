import java.util.PriorityQueue
import java.util.StringTokenizer

private const val MAX_VALUE = 200_000_000

data class Node(val to: Int, val weight: Int)

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    val E = st.nextToken().toInt()
    val graph = Array(N + 1) { ArrayList<Node>() }

    repeat(E) {
        st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        graph[a].add(Node(b, c))
        graph[b].add(Node(a, c))
    }

    fun dijkstra(start: Int): IntArray {
        val dist = IntArray(N + 1) { MAX_VALUE }
        val pq = PriorityQueue<Node>(compareBy { it.weight })

        pq.add(Node(start, 0))
        dist[start] = 0

        while (pq.isNotEmpty()) {
            val current = pq.poll()

            if (dist[current.to] < current.weight) continue

            for (neighbor in graph[current.to]) {
                if (dist[neighbor.to] > neighbor.weight + current.weight) {
                    dist[neighbor.to] = neighbor.weight + current.weight
                    pq.add(Node(neighbor.to, dist[neighbor.to]))
                }
            }
        }
        return dist
    }

    st = StringTokenizer(readLine())
    val v1 = st.nextToken().toInt()
    val v2 = st.nextToken().toInt()

    val distFromStart = dijkstra(1)
    val distFromV1 = dijkstra(v1)
    val distFromV2 = dijkstra(v2)

    val path1 = distFromStart[v1] + distFromV1[v2] + distFromV2[N]
    val path2 = distFromStart[v2] + distFromV2[v1] + distFromV1[N]

    val result = minOf(path1, path2)

    println(if (result >= MAX_VALUE) -1 else result)
}
