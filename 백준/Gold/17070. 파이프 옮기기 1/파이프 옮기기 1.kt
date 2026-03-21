import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pipes = Array(n) {
        val st = StringTokenizer(readLine())
        IntArray(n) { st.nextToken().toInt() }
    }
    var result = 0

    fun canMove(r: Int, c: Int): Boolean = r in 0..<n && c in 0..<n && pipes[r][c] == 0

    fun canDiagonal(r: Int, c: Int): Boolean {
        if (r + 1 !in 0..<n || c + 1 !in 0..<n) return false
        return pipes[r][c + 1] == 0 && pipes[r + 1][c + 1] == 0 && pipes[r + 1][c] == 0
    }

    fun dfs(r: Int, c: Int, direct: Direct) {
        if (r == n - 1 && c == n - 1) {
            result++
            return
        }

        when (direct) {
            Direct.Right -> {
                if (canMove(r, c + 1)) dfs(r, c + 1, Direct.Right)
                if (canDiagonal(r, c)) dfs(r + 1, c + 1, Direct.Diagonal)
            }

            Direct.Bottom -> {
                if (canMove(r + 1, c)) dfs(r + 1, c, Direct.Bottom)
                if (canDiagonal(r, c)) dfs(r + 1, c + 1, Direct.Diagonal)
            }

            Direct.Diagonal -> {
                if (canMove(r + 1, c)) dfs(r + 1, c, Direct.Bottom)
                if (canMove(r, c + 1)) dfs(r, c + 1, Direct.Right)
                if (canDiagonal(r, c)) dfs(r + 1, c + 1, Direct.Diagonal)
            }
        }
    }

    dfs(0, 1, Direct.Right)
    println(result)
}

enum class Direct { Right, Bottom, Diagonal }