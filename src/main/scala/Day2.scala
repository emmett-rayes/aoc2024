object Day2 {
    private type Input = List[List[Int]]

    def parse(input: String): Input =
        input.split("\n").map(_.split("\\s+").toList.map(_.toInt)).toList

    object Part1 {
        private type Output = Int

        def solve(input: Input): Output = {
            input.count { report =>
                if report.size <= 1 then true
                else
                    val increasing = report.head < report.tail.head
                    report.zip(report.drop(1)).forall { (prev, curr) =>
                        val monotonicity = if increasing then prev < curr else prev > curr
                        val distance = 1 <= math.abs(curr - prev) && math.abs(curr - prev) <= 3
                        monotonicity && distance
                    }
            }
        }
    }

    object Part2 {
        private type Output = Int

        def solve(input: Input): Output = {
            ???
        }
    }
}
