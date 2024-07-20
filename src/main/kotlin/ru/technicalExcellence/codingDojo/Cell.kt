package ru.technicalExcellence.codingDojo

data class Cell(
    val x: Int,
    val y: Int
) {

    fun neybors(): Set<Cell> {
        return setOf(
            Cell(x - 1, y - 1),
            Cell(x - 1, y),
            Cell(x - 1, y + 1),
            Cell(x, y - 1),
            Cell(x, y + 1),
            Cell(x + 1, y - 1),
            Cell(x + 1, y),
            Cell(x + 1, y + 1),
        )
    }
}
