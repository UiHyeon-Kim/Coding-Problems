fun main() {
    val testPlace = readln().toInt()
    val testPserson = readln().split(" ").map { it.toInt() }
    val (sv1, sv2) = readln().split(" ").map { it.toInt() }
    var cnt = 0L

    var tmp = 0
    repeat(testPserson.size){
        tmp = testPserson[it] - sv1
        cnt++
        if (tmp > 0){
            if (tmp >= sv2) {
                cnt += tmp / sv2
                if (tmp % sv2 > 0) cnt++
            }
            else cnt++
        }
    }
    println(cnt)
}