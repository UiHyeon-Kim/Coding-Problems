// https://www.acmicpc.net/problem/29754
// 매주 5회, 총 60시간 이상 방송
data class Broadcast(val day: Int, val start: Int, val end: Int, val totalTime: Int)

private fun String.toTime() = split(":").map(String::toInt).run { first() * 60 + last() }

fun main() = with(System.`in`.bufferedReader()) {
    val (broadcasts, latestDay) = readLine().split(" ").map { it.toInt() }
    val vTuberMap = mutableMapOf<String, MutableList<Broadcast>>()
    val totalWeeks = latestDay / 7

    repeat(broadcasts) {
        val input = readLine().split(" ")
        val name = input[0]
        val day = input[1].toInt()
        val startTime = input[2].toTime()
        val endTime = input[3].toTime()
        val todayTime = endTime - startTime

        vTuberMap.getOrPut(name) { mutableListOf() }.add(Broadcast(day, startTime, endTime, todayTime))
    }

    val realVTuber = vTuberMap.filter { (_, broadcasts) ->
        val broadcastsByWeek = broadcasts.groupBy { (it.day - 1) / 7 }

        (0..<totalWeeks).all { week ->
            broadcastsByWeek[week]?.let { weekBroadcasts ->
                weekBroadcasts.size >= 5 && weekBroadcasts.sumOf { it.totalTime } >= 3600
            } ?: false
        }
    }.keys.sorted()

    if (realVTuber.isEmpty()) {
        println(-1)
    } else {
        realVTuber.forEach(::println)
    }
}

