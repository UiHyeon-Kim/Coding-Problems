fun main() {
    val cnt = readln().toInt()
    val nums = readln()
    var sum = 0

    for (i in 0 until cnt){
        sum += nums[i] - '0'
    }
    println(sum)
}