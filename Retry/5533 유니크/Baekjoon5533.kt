class Baekjoon5533 {

    private lateinit var submitScore: Array<IntArray>
    private lateinit var totalScore: IntArray
    private lateinit var scoreCount: Array<IntArray>

    fun solve() {
        val players = readln().toInt()

        submitScore = Array(players) { readln().split(" ").map { it.toInt() }.toIntArray() }
        totalScore = IntArray(players)
        scoreCount = Array(GAME_COUNT) { IntArray(NUMBER_RANGE) } // 라운드, 점수

        for (player in START_INDEX until players) {
            for (round in START_INDEX until GAME_COUNT) {
                val currentScore = submitScore[player][round]
                scoreCount[round][currentScore]++
            }
        }

        for (player in START_INDEX until players) {
            for (round in START_INDEX until GAME_COUNT) {
                val score = submitScore[player][round]

                if (scoreCount[round][score] == ONE_PERSON) totalScore[player] += score
            }
        }

        totalScore.forEach { println(it) }
    }

    companion object {
        private const val GAME_COUNT = 3
        private const val NUMBER_RANGE = 101
        private const val START_INDEX = 0
        private const val ONE_PERSON = 1
    }
}

fun main() {
    Baekjoon5533().solve()
}
