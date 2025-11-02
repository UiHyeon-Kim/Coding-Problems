fun main() {
    val (lake, house) = readln().split(" ").map { it.toInt() }
    val lakeLocation = readln().split(" ").map { it.toInt() }

    val visited = mutableSetOf<Int>() // 메모리 초과 방지 (사이즈 2억 그대로 줄 경우 메모리 초과)
    val q = ArrayDeque<Pair<Int, Int>>() // 위치, 거리

    val find = listOf(-1, 1)
    var result = 0L
    var cnt = 0

    for (loc in lakeLocation) {
        q.add(loc to 0)
        visited.add(loc)
    }

    loop@ while (q.isNotEmpty()) {
        val (lakeLoc, distance) = q.removeFirst()

        for (f in find) {
            val newLoc = lakeLoc + f

            if (newLoc !in visited) {
                q.add(newLoc to distance + 1)
                visited.add(newLoc)

                result += distance + 1
                cnt++
                if (cnt == house) break@loop
            }
        }
    }

    println(result)
}
