fun main() {
    val t = readln().toInt()
    val sb = StringBuilder()

    repeat(t){
        val c = readln().split(" ")
        val r = c[0].toInt()
        val s = c[1]

        for (i in 0 until  s.length){
            repeat(r){
                sb.append(s[i])
            }

        }
        println(sb)
        sb.clear()
    }

}