object Day1 {
    object Part1 {
        private type Input = (List[Int], List[Int])
        private type Output = Int

        def parse(input: String): Input = {
            val array = input
                .split("\n")
                .map(_.split("\\s+"))
                .map(_.map(_.toInt))
                .transpose
                .map(_.toList)

            array match
                case Array(first, second) => (first, second)
        }

        def solve(input: Input): Output =
            input._1.sorted
                .zip(input._2.sorted)
                .foldLeft(0)((sum, pair) => sum + math.abs(pair._1 - pair._2))
    }
}
