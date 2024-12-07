object Day1 {
    object Part1 {
        type Input = (List[Int], List[Int])

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

        def solve(input: Input): Int = {
            ???
        }
    }
}
