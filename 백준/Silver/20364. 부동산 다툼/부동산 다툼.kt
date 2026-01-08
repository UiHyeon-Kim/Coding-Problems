class Baekjoon20364 {

    private lateinit var purchased: BooleanArray
    private lateinit var sb: StringBuilder

    fun solve() = with(System.`in`.bufferedReader()) {

        val (totalLand, ducks) = readLine().split(" ").map(String::toInt)

        purchased = BooleanArray(totalLand + 1)
        sb = StringBuilder()

        repeat(ducks) {
            val wantLand = readLine().toInt()

            findAvailableLand(wantLand)
        }

        println(sb)
    }

    /** 자식 -> 부모 방향 탐색 */
    private fun findAvailableLand(wantLand: Int) {
        var currentLand = wantLand  // 현재 위치하는 땅
        var nonePass = 0            // 막히는 땅

        while (currentLand > 0) {

            // 현재 위치한 땅이 이미 구매된 땅이면 막힌 땅 체크
            if (purchased[currentLand]) {
                nonePass = currentLand
            }

            currentLand /= 2
        }

        // 막는 땅이 없으면 방문처리
        if (nonePass == 0) {
            purchased[wantLand] = true
        }

        sb.append(nonePass).append('\n')
    }
}

fun main() {
    Baekjoon20364().solve()
}
