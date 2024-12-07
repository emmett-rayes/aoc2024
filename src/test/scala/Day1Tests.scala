class Day1Tests extends munit.FunSuite {
    test("parsing") {
        val input =
            """|3   4
               |4   3
               |2   5
               |1   3
               |3   9
               |3   3
               |""".stripMargin

        val expected = (
          List(3, 4, 2, 1, 3, 3),
          List(4, 3, 5, 3, 9, 3),
        )
        val obtained = Day1.parse(input)
        assertEquals(clue(obtained), expected)
    }

    test("part1 example") {
        val input =
            """|3   4
               |4   3
               |2   5
               |1   3
               |3   9
               |3   3
               |""".stripMargin

        val expected = 11
        val obtained = Day1.Part1.solve(Day1.parse(input))
        assertEquals(clue(obtained), expected)
    }

    test("part1 solution") {
        val input = os.read(os.Path(getClass.getResource("Day1").toURI))
        val expected = 1320851
        val obtained = Day1.Part1.solve(Day1.parse(input))
        assertEquals(clue(obtained), expected)
    }

    test("part2 example") {
        val input =
            """|3   4
               |4   3
               |2   5
               |1   3
               |3   9
               |3   3
               |""".stripMargin

        val expected = 31
        val obtained = Day1.Part2.solve(Day1.parse(input))
        assertEquals(clue(obtained), expected)
    }

    test("part2 solution") {
        val input = os.read(os.Path(getClass.getResource("Day1").toURI))
        val expected = 26859182
        val obtained = Day1.Part2.solve(Day1.parse(input))
        assertEquals(clue(obtained), expected)
    }
}
