fun main() {
    val t = readln().toInt()
    repeat(t) {
        var card = readln().toMutableList()
        var num = 0
        var sum = 0

        for ((index, value) in card.withIndex()) {
            if (index % 2 == 0) {
                num = (value - '0') * 2
                if (num >= 10) card[index] = ((num / 10 + num % 10) + '0'.code).toChar()
                else card[index] = (num + '0'.code).toChar()
            }
            sum += card[index] - '0'
        }
        println(if (sum % 10 == 0) 'T' else 'F')
    }
}