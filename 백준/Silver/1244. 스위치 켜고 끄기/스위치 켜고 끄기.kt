fun main() {
    val switchCount = readln().toInt()
    val switch = readln().split(" ").map { it.toInt() }.toIntArray()
    val studentCount = readln().toInt()

    repeat(studentCount) {
        val (gender, num) = readln().split(" ").map { it.toInt() }

        if (gender == 1) {
            var index = num

            while (index <= switchCount) {
                if (switch[index - 1] == 0) switch[index - 1] = 1
                else switch[index - 1] = 0

                index += num
            }
        } else {
            var left = num - 2
            var right = num

            if (switch[num - 1] == 0) switch[num - 1] = 1
            else switch[num - 1] = 0

            while (left >= 0 && right < switchCount && switch[left] == switch[right]) {
                if (switch[left] == 0) {
                    switch[left] = 1
                    switch[right] = 1
                } else {
                    switch[left] = 0
                    switch[right] = 0
                }
                left--
                right++
            }
        }
    }

    for (i in switch.indices) {
        print("${switch[i]} ")
        if ((i + 1) % 20 == 0) println()
    }
}