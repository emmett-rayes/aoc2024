class Day3Tests extends munit.FunSuite {
    test("parsing") {
        val input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
        val expected = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
        val obtained = Day3.parse(input)
        assertEquals(clue(obtained), expected)
    }

    test("part1 example") {
        val input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
        val expected = 161
        val obtained = Day3.Part1.solve(Day3.parse(input))
        assertEquals(clue(obtained), expected)
    }

    test("part1 solution") {
        val input = os.read(os.Path(getClass.getResource("Day3").toURI))
        val expected = 188741603
        val obtained = Day3.Part1.solve(Day3.parse(input))
        assertEquals(clue(obtained), expected)
    }

    test("part2 example") {
        val input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"
        val expected = 48
        val obtained = Day3.Part2.solve(Day3.parse(input))
        assertEquals(clue(obtained), expected)
    }

    test("part2 solution") {
        val input = os.read(os.Path(getClass.getResource("Day3").toURI))
        val expected = 67269798
        val obtained = Day3.Part2.solve(Day3.parse(input))
        assertEquals(clue(obtained), expected)
    }
}
