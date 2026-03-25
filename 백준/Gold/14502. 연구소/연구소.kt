package `14502 연구소`

import java.util.StringTokenizer

class Baekjoon14502() {

    private lateinit var lab: Array<IntArray>
    private lateinit var infectiousAgents: MutableList<Pair<Int, Int>>
    private lateinit var emptyArea: MutableList<Pair<Int, Int>>
    private var r = 0
    private var c = 0
    private var max = 0

    fun solve() = with(System.`in`.bufferedReader()) {
        var st = StringTokenizer(readLine())
        r = st.nextToken().toInt()
        c = st.nextToken().toInt()

        infectiousAgents = mutableListOf()
        emptyArea = mutableListOf()

        lab = Array(r) { i ->
            st = StringTokenizer(readLine())

            IntArray(c) { j ->
                val current = st.nextToken().toInt()

                if (current == 2) infectiousAgents.add(i to j)
                else if (current == 0) emptyArea.add(i to j)

                current
            }
        }

        buildWall(0, 0)
        println(max)
    }

    private fun buildWall(startIdx: Int, count: Int) {
        if (count == 3) {
            max = max.coerceAtLeast(getSafeArea(inspection()))
            return
        }

        for (i in startIdx..<emptyArea.size) {
            val (wr, wc) = emptyArea[i]
            lab[wr][wc] = 1
            buildWall(i + 1, count + 1)
            lab[wr][wc] = 0
        }
    }

    private fun getSafeArea(currentLab: Array<IntArray>): Int =
        currentLab.sumOf { it.count { area -> area == 0 } }

    private fun inspection(): Array<IntArray>{
        val direction = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
        val copyLab = Array(r) { lab[it].clone() }

        val dq = ArrayDeque<Pair<Int, Int>>()
        dq.addAll(infectiousAgents)

        while (dq.isNotEmpty()) {
            val (cr, cc) = dq.removeFirst()

            for ((dr, dc) in direction) {
                val nr = cr + dr
                val nc = cc + dc

                if (nr in 0..<r && nc in 0..<c && copyLab[nr][nc] == 0) {
                    copyLab[nr][nc] = 2
                    dq.add(nr to nc)
                }
            }
        }

        return copyLab
    }
}

fun main() {
    Baekjoon14502().solve()
}