fun main() {
    val cnt = readln().toInt()

    repeat(cnt) {
        val ps = readln()
        var yn = 0

        for (i in 0 until ps.length){
            if (ps[i] == '(') yn++
            else yn--

            if (yn < 0) break
        }
        if (yn == 0) println("YES")
        else println("NO")
    }
}