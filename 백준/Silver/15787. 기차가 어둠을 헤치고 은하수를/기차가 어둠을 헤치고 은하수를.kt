import java.util.*

class Baekjoon15787 {

    private lateinit var train: IntArray

    fun solve() = with(System.`in`.bufferedReader()) {
        val st = StringTokenizer(readLine())
        val (trainCount, commandCount) = st.nextToken().toInt() to st.nextToken().toInt()
        
        train = IntArray(trainCount)

        repeat(commandCount) {
            val input = StringTokenizer(readLine())
            executeCommand(input)
        }

        println(train.distinct().size)
    }

    private fun executeCommand(input: StringTokenizer) {
        val (command, car) = input.nextToken().toInt() to input.nextToken().toInt() - 1

        when (command) {
            BOARDING -> {
                val seat = input.nextToken().toInt() - 1
                train[car] = train[car] or (1 shl seat)
            }

            STOPOVER -> {
                val seat = input.nextToken().toInt() - 1
                train[car] = train[car] and (1 shl seat).inv()
            }

            MOVE_LEFT -> {
                train[car] = (train[car] shl 1) and ((1 shl 20) - 1)
            }

            MOVE_RIGHT -> {
                train[car] = train[car] shr 1
            }
        }
    }

    companion object {
        private const val BOARDING = 1
        private const val STOPOVER = 2
        private const val MOVE_LEFT = 3
        private const val MOVE_RIGHT = 4
    }
}

fun main() {
    Baekjoon15787().solve()
}