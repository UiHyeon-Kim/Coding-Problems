fun main() {
    val n = readln().toInt()
    val nums = readln().split(" ").map { it.toInt() }
    var count = 0
    var result = 0

    for (i in nums.indices) {
        if (nums[i] == 0) count++
        result += nums[i]
    }

    if (nums.size == count * 2) println("INVALID")
    else if (result > 0) println("APPROVED")
    else println("REJECTED")
}
