class Day2Tests extends munit.FunSuite {
    test("parsing") {
        val input =
            """|1 2 7 8 9
               |9 7 6 2 1
               |1 3 2 4 5
               |8 6 4 4 1
               |1 3 6 7 9
               |""".stripMargin

        val expected = List(
          List(1, 2, 7, 8, 9),
          List(9, 7, 6, 2, 1),
          List(1, 3, 2, 4, 5),
          List(8, 6, 4, 4, 1),
          List(1, 3, 6, 7, 9),
        )
        val obtained = Day2.parse(input)
        assertEquals(clue(obtained), expected)
    }
}
