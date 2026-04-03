import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val indegree = IntArray(n + 1)
    val graph = Array(n + 1) { ArrayList<Int>() }

    repeat(m) {
        st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        graph[a].add(b)
        indegree[b]++
    }

    val q = ArrayDeque<Int>()
    for (i in 1..n) {
        if (indegree[i] == 0) q.add(i)
    }

    val sb = StringBuilder()
    while (q.isNotEmpty()) {
        val current = q.removeFirst()
        sb.append(current).append(' ')

        for (next in graph[current]) {
            if (--indegree[next] == 0) q.add(next)
        }
    }

    println(sb)
}