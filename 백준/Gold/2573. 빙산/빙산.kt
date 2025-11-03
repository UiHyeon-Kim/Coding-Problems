fun main() {
    val (row, col) = readln().split(" ").map { it.toInt() }
    var sea = Array(row) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val direction = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
    var currentYear = 0

    fun oneYearLater(): Array<IntArray> {
        val newSea = Array(row) { sea[it].clone() }

        for (r in 0 until row) {
            for (c in 0 until col) {
                if (sea[r][c] == 0) continue

                var side = 0

                for ((dx, dy) in direction) {
                    val nx = c + dx
                    val ny = r + dy

                    if (nx !in 0 until col || ny !in 0 until row) continue
                    if (sea[ny][nx] == 0) side++
                }
                newSea[r][c] = (sea[r][c] - side).coerceAtLeast(0)
            }
        }

        return newSea
    }

    fun checkIceberg(x: Int, y: Int, visited: Array<BooleanArray>) {
        val q = ArrayDeque<Pair<Int, Int>>()

        q.add(x to y)
        visited[x][y] = true

        while (q.isNotEmpty()) {
            val (cx, cy) = q.removeFirst()
            for ((dx, dy) in direction) {
                val nx = cx + dx
                val ny = cy + dy

                if (nx !in 0 until row || ny !in 0 until col) continue
                if (!visited[nx][ny] && sea[nx][ny] != 0) {
                    visited[nx][ny] = true
                    q.add(nx to ny)
                }
            }
        }
    }

    while (true) {
        val visited = Array(row) { BooleanArray(col)}
        var iceBerg = 0

        repeat(row) { r ->
            repeat(col) { c ->
                if (sea[r][c] != 0 && !visited[r][c]) {
                    checkIceberg(r, c, visited)
                    iceBerg++
                }
            }
        }

        if (iceBerg >= 2) {
            println(currentYear)
            return
        } else if (iceBerg == 0) {
            println(0)
            return
        }

        currentYear++
        sea = oneYearLater()
    }
}