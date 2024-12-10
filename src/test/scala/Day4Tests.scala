class Day4Tests extends munit.FunSuite {
    test("parsing") {
        val input =
            """|MMMSXXMASM
               |MSAMXMSMSA
               |AMXSXMAAMM
               |MSAMASMSMX
               |XMASAMXAMM
               |XXAMMXXAMA
               |SMSMSASXSS
               |SAXAMASAAA
               |MAMMMXMMMM
               |MXMXAXMASX
               |""".stripMargin

        val expected =
            List(
              List('M', 'M', 'M', 'S', 'X', 'X', 'M', 'A', 'S', 'M'),
              List('M', 'S', 'A', 'M', 'X', 'M', 'S', 'M', 'S', 'A'),
              List('A', 'M', 'X', 'S', 'X', 'M', 'A', 'A', 'M', 'M'),
              List('M', 'S', 'A', 'M', 'A', 'S', 'M', 'S', 'M', 'X'),
              List('X', 'M', 'A', 'S', 'A', 'M', 'X', 'A', 'M', 'M'),
              List('X', 'X', 'A', 'M', 'M', 'X', 'X', 'A', 'M', 'A'),
              List('S', 'M', 'S', 'M', 'S', 'A', 'S', 'X', 'S', 'S'),
              List('S', 'A', 'X', 'A', 'M', 'A', 'S', 'A', 'A', 'A'),
              List('M', 'A', 'M', 'M', 'M', 'X', 'M', 'M', 'M', 'M'),
              List('M', 'X', 'M', 'X', 'A', 'X', 'M', 'A', 'S', 'X'),
            )
        val obtained = Day4.parse(input)
        assertEquals(clue(obtained), expected)
    }

    test("part1 example") {
        val input =
            """|MMMSXXMASM
               |MSAMXMSMSA
               |AMXSXMAAMM
               |MSAMASMSMX
               |XMASAMXAMM
               |XXAMMXXAMA
               |SMSMSASXSS
               |SAXAMASAAA
               |MAMMMXMMMM
               |MXMXAXMASX
               |""".stripMargin

        val expected = 18
        val obtained = Day4.Part1.solve(Day4.parse(input))
        assertEquals(clue(obtained), expected)
    }

    test("part1 solution") {
        val input = os.read(os.Path(getClass.getResource("Day4").toURI))
        val expected = 2406
        val obtained = Day4.Part1.solve(Day4.parse(input))
        assertEquals(clue(obtained), expected)
    }

    test("part2 example") {
        val input =
            """|MMMSXXMASM
               |MSAMXMSMSA
               |AMXSXMAAMM
               |MSAMASMSMX
               |XMASAMXAMM
               |XXAMMXXAMA
               |SMSMSASXSS
               |SAXAMASAAA
               |MAMMMXMMMM
               |MXMXAXMASX
               |""".stripMargin

        val expected = 9
        val obtained = Day4.Part2.solve(Day4.parse(input))
        assertEquals(clue(obtained), expected)
    }

    test("part2 solution") {
        val input = os.read(os.Path(getClass.getResource("Day4").toURI))
        val expected = 1807
        val obtained = Day4.Part2.solve(Day4.parse(input))
        assertEquals(clue(obtained), expected)
    }
}
