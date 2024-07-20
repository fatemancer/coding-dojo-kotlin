package ru.technicalExcellence.codingDojo

class Field(
    val aliveCells: Set<Cell>
) {
//    fun next(): Field {
//
//        aliveCells.map { it to  aliveNeybors(it.neybors()).size}
//
//    }

    fun neighbours(): Set<Cell> {
      return aliveCells.flatMap { it.neybors() }.toSet()
    }



}

fun regex() {
    val rx = "<.+?>".toRegex()
    val rr = rx.findAll("<h5 id=\"description\">Description</h5>\n" +
            "<p>Two spots are not enough for a parking lot, so let's increase the number of parking spaces. We'll jump straight to 20 spaces, numbered from 1 to 20. Initially, all the spots are vacant.</p>\n" +
            "<p>When the user wants to park the car, the program should find an available parking spot with the lowest number.</p>\n" +
            "<p>The user can write commands <code class=\"java\">park</code><strong> </strong>and <code class=\"java\">leave</code><strong> </strong>repeatedly and type <code class=\"java\">exit</code> to end the program.</p>\n" +
            "<p>If the parking lot is full and there's no room, the program should type <code class=\"java\">Sorry, the parking lot is full.</code>.</p>\n" +
            "<p>If there are several available spots for a car, the program should always assign the spot with the lowest number.</p>\n" +
            "<h5 id=\"example\">Example</h5>\n" +
            "<p> The symbol <code class=\"java\">&gt; </code> represents the user input. Note that it's not part of the input.</p>\n" +
            "<pre><code class=\"language-no-highlight\">&gt; park KA-01-HH-9999 White\n" +
            "White car parked in spot 1.\n" +
            "&gt; park KA-01-HH-3672 Green\n" +
            "Green car parked in spot 2.\n" +
            "...\n" +
            "\n" +
            "&gt; park Rs-P-N-21 Red\n" +
            "Sorry, the parking lot is full.\n" +
            "&gt; leave 1\n" +
            "Spot 1 is free.\n" +
            "&gt; park Rs-P-N-21 Red\n" +
            "Red car parked in spot 1.\n" +
            "&gt; exit</code></pre>")
    println(rr)

}

fun main() {
    regex()
}
