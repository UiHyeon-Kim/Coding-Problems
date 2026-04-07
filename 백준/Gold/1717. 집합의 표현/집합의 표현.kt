import java.util.StringTokenizer

class Baekjoon1717 {

    private lateinit var parent: IntArray
    private lateinit var rank: IntArray

    fun solve() = with(System.`in`.bufferedReader()) {
        var st = StringTokenizer(readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        val sb = StringBuilder()

        parent = IntArray(n + 1) { it }
        rank = IntArray(n + 1)

        repeat(m) {
            st = StringTokenizer(readLine())
            val cmd = st.nextToken().toInt()
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()

            if (cmd == 0) {
                union(a, b)
            } else {
                if (find(a) == find(b)) {
                    sb.append("YES").append("\n")
                } else {
                    sb.append("NO").append("\n")
                }
            }
        }

        println(sb)
    }

    private fun find(x: Int): Int {
        if (parent[x] == x) return x
        parent[x] = find(parent[x])
        return parent[x]
    }

    private fun union(a: Int, b: Int) {
        val rootA = find(a)
        val rootB = find(b)

        if (rootA != rootB) {
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB
            } else if (rank[rootB] < rank[rootA]) {
                parent[rootB] = rootA
            } else {
                parent[rootB] = rootA
                rank[rootA]++
            }
        }
    }
}

fun main() {
    Baekjoon1717().solve()
}