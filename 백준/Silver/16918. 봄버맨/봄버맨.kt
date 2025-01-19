fun main() {
    val (r, c, second) = readln().split(" ").map { it.toInt() }
    val grid = Array(r) { readln().toCharArray() }

    val result = when {
        second == 1 -> grid
        second % 2 == 0 -> Array(r) { CharArray(c) { 'O' } }
        second % 4 == 3 -> bomberMan(grid, r, c)
        else -> bomberMan(bomberMan(grid, r, c), r, c)
    }
        
    result.forEach { println(it.joinToString("")) }
}

fun bomberMan(grid: Array<CharArray>, r: Int, c: Int): Array<CharArray> {
    val direction = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
    val result = Array(r) { CharArray(c) { 'O' } }

    for (x in 0..<r) {
        for (y in 0..<c) {
            if (grid[x][y] == 'O') {
                result[x][y] = '.'
                for ((dx, dy) in direction) {
                    val nx = x + dx
                    val ny = y + dy
                    if (nx in 0..<r && ny in 0..<c) result[nx][ny] = '.'
                }
            }
        }
    }
    return result
}
