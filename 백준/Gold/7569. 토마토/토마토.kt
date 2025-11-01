import kotlin.math.max

data class Coordinate(val z: Int, val x: Int, val y: Int)

fun main() {
    val (row, col, height) = readln().split(" ").map { it.toInt() }
    val boxes = Array(height) { Array(col) { IntArray(row) } }
    val dist = Array(height) { Array(col) { IntArray(row) { -1 } } }
    val q = ArrayDeque<Coordinate>()
    var result = 0

    val dz = listOf(-1, 1, 0, 0, 0, 0)
    val dx = listOf(0, 0, -1, 1, 0, 0)
    val dy = listOf(0, 0, 0, 0, -1, 1)

    repeat(height) { h ->
        repeat(col) { c ->
            boxes[h][c] = readln().split(" ").map { it.toInt() }.toIntArray()
        }
    }

    for (h in 0 until height) {
        for (c in 0 until col) {
            for (r in 0 until row) {
                if (boxes[h][c][r] == 1) {
                    dist[h][c][r] = 0
                    q.add(Coordinate(h, r, c))
                }
            }
        }
    }

    while (q.isNotEmpty()) {
        val (cz, cx, cy) = q.removeFirst()

        for (i in dz.indices) {
            val nz = cz + dz[i]
            val nx = cx + dx[i]
            val ny = cy + dy[i]

            if (nz !in 0 until height || nx !in 0 until row || ny !in 0 until col) continue
            if (boxes[nz][ny][nx] != -1 && dist[nz][ny][nx] == -1) {
                dist[nz][ny][nx] = dist[cz][cy][cx] + 1
                q.add(Coordinate(nz, nx, ny))
            }
        }
    }

    for (h in 0 until height) {
        for (c in 0 until col) {
            for (r in 0 until row) {
                if (dist[h][c][r] == -1 && boxes[h][c][r] == 0) {
                    println(-1)
                    return
                }
                result = max(result, dist[h][c][r])
            }
        }
    }

    println(result)
}
