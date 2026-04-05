import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val parent = IntArray(n + 1) { it }
    val sb = StringBuilder()

    fun find(x: Int): Int {
        if (parent[x] == x) return x
        parent[x] = find(parent[x])
        return parent[x]
    }

    repeat(m) {
        st = StringTokenizer(readLine())
        val cmd = st.nextToken().toInt()
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        if (cmd == 0) {
            val ap = find(a)
            val bp = find(b)
            if (ap != bp) parent[ap] = bp
        } else {
            sb.append(
                if (find(a) == find(b)) "YES" else "NO"
            ).append("\n")
        }
    }

    println(sb)
}