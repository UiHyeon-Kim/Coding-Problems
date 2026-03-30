import java.util.PriorityQueue
import java.util.StringTokenizer

data class Meeting(val start: Int, val end: Int)

class Baekjoon1931 {

    private lateinit var st: StringTokenizer

    fun solve() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val pq = PriorityQueue(compareBy<Meeting>({ it.end }, { it.start }))

        repeat(n) {
            st = StringTokenizer(readLine())
            pq.add(Meeting(st.nextToken().toInt(), st.nextToken().toInt()))
        }

        println(getMaxMeeting(pq))
    }

    private fun getMaxMeeting(pq: PriorityQueue<Meeting>): Int {
        val meetings = mutableListOf<Meeting>()

        meetings.add(pq.poll())

        while (pq.isNotEmpty()) {
            val meeting = pq.poll()

            if (meetings.last().end <= meeting.start) {
                meetings.add(Meeting(meeting.start, meeting.end))
            }
        }

        return meetings.size
    }
}

fun main() {
    Baekjoon1931().solve()
}