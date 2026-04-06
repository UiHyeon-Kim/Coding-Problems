import java.util.StringTokenizer

class Baekjoon1197 {

    data class Edge(val start: Int, val end: Int, val weight: Int)

    private lateinit var edges: MutableList<Edge>
    private lateinit var parent: IntArray

    fun solve() = with(System.`in`.bufferedReader()) {
        var st = StringTokenizer(readLine())
        val V = st.nextToken().toInt()
        val E = st.nextToken().toInt()
        edges = mutableListOf()

        repeat(E) {
            st = StringTokenizer(readLine())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            val c = st.nextToken().toInt()

            edges.add(Edge(a, b, c))
        }

        edges.sortBy { it.weight }

        println(unionFind(V))
    }

    private fun unionFind(v: Int): Int {

        var sum = 0
        parent = IntArray(v + 1) { it }

        fun find(x: Int): Int {
            if (parent[x] == x) return parent[x]
            parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(edge: Edge) {
            val rootA = find(edge.start)
            val rootB = find(edge.end)

            if (rootA != rootB) {
                parent[rootA] = rootB
                sum += edge.weight
            }
        }

        for (edge in edges) {
            union(edge)
        }

        return sum
    }
}

fun main() {
    Baekjoon1197().solve()
}