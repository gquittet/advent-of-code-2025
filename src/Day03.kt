fun main() {
    fun part1(input: List<String>): Int = input.sumOf { line ->
        val list = line.toList()
        val max = list.withIndex().maxBy { it.value }
        when {
            max.index == list.size - 1 -> {
                val second = list.take(max.index).max()
                "$second${max.value}".toInt()
            }

            else -> {
                val second = list.subList(max.index + 1, list.size).max()
                "${max.value}$second".toInt()
            }
        }
    }

    fun buildVoltage(numbers: List<Char>, size: Int): Long {
        val stack = ArrayDeque<Int>()
        var removals = 0
        val maxRemovals = numbers.size - size

        for (digit in numbers.map { it.digitToInt() }) {
            while (stack.isNotEmpty() && stack.last() < digit && removals < maxRemovals) {
                stack.removeLast()
                removals += 1
            }
            stack.add(digit)
        }

        return stack.take(size).joinToString("").toLong()
    }

    fun part2(input: List<String>): Long = input.sumOf { buildVoltage(it.toList(), 12) }

    val input = readInput("Day03")

    val test1 = readInput("Day03_test")
    check(part1(test1) == 357)

    val test2 = readInput("Day03_test")
    check(part2(test2) == 3121910778619)

    part1(input).println()
    part2(input).println()
}