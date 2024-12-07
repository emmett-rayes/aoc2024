object Day2 {
    private type Input = List[List[Int]]

    def parse(input: String): Input =
        input.split("\n").map(_.split("\\s+").toList.map(_.toInt)).toList

    object Part1 {
        private type Output = Int

        def solve(input: Input): Output = {
            ???
        }
    }
}
