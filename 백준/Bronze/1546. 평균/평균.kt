fun main() {
    val count = readln().toInt()
    val arr = readln().split(" ").map { it.toDouble() }
    var result = 0.0
    var sum = 0.0

    val max = arr.max()

    for (i in arr){
        result = i / max * 100
        sum += result
    }

    println(sum / count)
}