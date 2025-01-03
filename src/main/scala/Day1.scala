object Day1 {
    private type Input = (List[Int], List[Int])

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

    object Part1 {
        private type Output = Int

        def solve(input: Input): Output =
            input._1.sorted
                .zip(input._2.sorted)
                .foldLeft(0)((sum, pair) => sum + math.abs(pair._1 - pair._2))
    }

    object Part2 {
        private type Output = Int

        def solve(input: Input): Output =
            val frequencies = input._2
                .groupBy(identity)
                .view.mapValues(_.size)
                .toMap.withDefaultValue(0)

            input._1.foldLeft(0)((sum, a) => sum + a * frequencies(a))
    }
}
