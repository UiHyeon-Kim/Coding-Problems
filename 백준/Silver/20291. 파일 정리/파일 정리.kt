fun main() {
    val map = mutableMapOf<String, Int>()

    repeat(readln().toInt()) {
        val file = readln()
        val extension = file.substring(file.indexOf('.') + 1)
        map[extension] = map.getOrDefault(extension, 0) + 1
    }

    map.toSortedMap().forEach { (ext, cnt) -> println("$ext $cnt") }
}