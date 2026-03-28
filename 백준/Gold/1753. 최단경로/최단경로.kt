import java.util.PriorityQueue
import java.util.StringTokenizer

data class Node(val to: Int, val weight: Int)

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val V = st.nextToken().toInt()  // 정점 수
    val E = st.nextToken().toInt()  // 간선 수
    val K = readLine().toInt()      // 시작 정점 번호
    val graph = Array(V + 1) { ArrayList<Node>() }  // 그래프 정보

    repeat(E) {
        st = StringTokenizer(readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        val w = st.nextToken().toInt()

        graph[u].add(Node(v, w))
    }

    val pq = PriorityQueue<Node>(compareBy { it.weight })
    val dist = IntArray(V + 1) { Int.MAX_VALUE } // 최단거리 정보

    pq.add(Node(K, 0))
    dist[K] = 0

    while (pq.isNotEmpty()) {
        val (curStart, curDist) = pq.poll()

        if (curDist > dist[curStart]) continue

        for (node in graph[curStart]) {
            val to = node.to
            val weight = node.weight

            if (dist[to] > weight + curDist) {
                dist[to] = weight + curDist
                pq.add(Node(to, weight + curDist))
            }
        }
    }

    for (i in 1..V) {
        if (dist[i] == Int.MAX_VALUE) println("INF")
        else println(dist[i])
    }
}