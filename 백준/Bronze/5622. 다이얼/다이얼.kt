fun main() {
    val tel = readln()
    var sec = 2
    var result = 0

    repeat(tel.length){
        when(tel[it].toInt()) {
            in 65..67 -> sec = 3
            in 68..70 -> sec = 4
            in 71..73 -> sec = 5
            in 74..76 -> sec = 6
            in 77..79 -> sec = 7
            in 80..83 -> sec = 8
            in 84..86 -> sec = 9
            in 87..90 -> sec = 10
        }
        result += sec
    }
    println(result)
}
