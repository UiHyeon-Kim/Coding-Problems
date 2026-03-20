import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val start = IntArray(n)
    val end = IntArray(n)

    for (i in 0..<n) {
        val st = StringTokenizer(readLine())
        start[i] = st.nextToken().toInt()
        end[i] = st.nextToken().toInt()
    }

    start.sort()
    end.sort()

    var rooms = 0
    var endIdx = 0

    for (startIdx in 0..<n) {
        if (start[startIdx] < end[endIdx]) {
            rooms++
        } else {
            endIdx++
        }
    }

    println(rooms)
}