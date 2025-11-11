fun main() = with(System.`in`.bufferedReader()) {
    val (N, Q) = readLine().split(" ").map { it.toInt() }
    val occupied = BooleanArray(N + 1)

    val sb = StringBuilder()

    repeat(Q) {
        var x = readLine().toInt()
        var cur = x
        var blocked = 0

        // 위로 올라가며 처음 만나는 점유된 땅을 찾기
        while (cur > 1) {
            if (occupied[cur]) {
                blocked = cur
            }
            cur /= 2
        }

        if (blocked == 0) {
            // 점유된 땅 없음 → x 점유
            occupied[x] = true
        }

        sb.append(blocked).append('\n')
    }

    print(sb.toString())
}