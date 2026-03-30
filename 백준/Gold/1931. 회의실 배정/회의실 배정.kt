import java.util.StringTokenizer

data class Meeting(val start: Int, val end: Int)

class Baekjoon1931 {

    fun solve() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val meetings = Array(n) {
            val st = StringTokenizer(readLine())
            Meeting(st.nextToken().toInt(), st.nextToken().toInt())
        }
        meetings.sortWith(compareBy({ it.end }, { it.start }))

        println(getMaxMeeting(meetings))
    }

    private fun getMaxMeeting(meetings: Array<Meeting>): Int {
        var endTime = 0
        var result = 0

        for (meeting in meetings) {
            if (endTime <= meeting.start) {
                endTime = meeting.end
                result++
            }
        }

        return result
    }
}

fun main() {
    Baekjoon1931().solve()
}