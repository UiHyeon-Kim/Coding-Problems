fun main(){
    val t = readln().toInt()
    var cnt = 1
    repeat(t) {
        val (n1, n2) = readln().split(" ").map { it.toInt() }
        println("Case $cnt: ${n1+n2}")
        cnt++
    }
}