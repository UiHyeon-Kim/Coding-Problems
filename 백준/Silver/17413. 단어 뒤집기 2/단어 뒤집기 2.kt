fun main() {
    val str = readln()
    val sb = StringBuilder()

    var start = 0
    var isAngleBracket = false

    for ((idx, c) in str.withIndex()) {
        if (isAngleBracket) {
            if (c == '>') {
                isAngleBracket = false
                start = idx + 1
            }
            sb.append(c)
            continue
        }

        if (c == '<' || c == ' ') {
            if (c == '<') isAngleBracket = true
            if (start != idx) sb.append(str.substring(start, idx).reversed())
            sb.append(c)
            start = idx + 1
        }
    }
    sb.append(str.substring(start, str.length).reversed())

    println(sb)
}