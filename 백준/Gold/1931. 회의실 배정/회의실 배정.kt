fun main() {
    val n = readln().toInt()
    val meetings = mutableListOf<Pair<Int, Int>>()


    repeat(n) {
        val (start, stop) = readln().split(" ").map { it.toInt() }
        meetings.add(start to stop)
    }

    val sortedMeetings = meetings.sortedWith(compareBy({ it.second }, { it.first }))
    var result = 0
    var meetingEnd = 0
    
    for ((start, end) in sortedMeetings) {
        if (start >= meetingEnd) {
            meetingEnd = end
            result++
        }
    }

    println(result)
}
