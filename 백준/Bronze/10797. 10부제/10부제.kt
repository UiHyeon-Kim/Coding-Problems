fun main() {
    val num = readln().toInt()
    val carNum = readln().split(" ").map { it.toInt() }
    var cnt = 0

    repeat(5){
        if (num == carNum[it]) cnt++
    }

    println(cnt)
}