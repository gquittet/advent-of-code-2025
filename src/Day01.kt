fun main() {
    val start = 50
    val circleSize = 100

    fun dialToMoves(dial: String): Int {
        val steps = dial.drop(1).toInt()
        val direction = when (dial.first()) {
            'L' -> -1
            'R' -> 1
            else -> error("Invalid direction: ${dial.first()}")
        }
        return steps * direction
    }

    fun part1(input: List<String>): Int =
        input.scan(start) { total, dial -> (total + dialToMoves(dial)).mod(circleSize) }.count { it == 0 }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
