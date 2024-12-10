object Day4 {
    private type Input = List[List[Char]]

    def parse(input: String): Input =
        input.split("\n").map(_.toCharArray.toList).toList

    object Part1 {
        private type Output = Int

        private def search(word: String, chars: Iterable[Char]): Int = {
            var count = 0
            var searching = word
            for c <- chars do {
                if c != searching.head then searching = word
                if c == searching.head then searching = searching.tail
                if searching.isEmpty then
                    count += 1
                    searching = word
            }
            count
        }

        private def diagonals(input: Input, half: "upper" | "lower", reversed: Boolean, strict: Boolean) = {
            def strictness(i: Int, j: Int) = if strict then (j + i) != j else true
            input.indices.collect { case i =>
                input.transpose.indices.collect {
                    case j if strictness(i, j) && j < input.size - i =>
                        (half, reversed) match
                            case ("upper", true)  => input(j).reverse(i + j)
                            case ("upper", false) => input(j)(i + j)
                            case ("lower", true)  => input(i + j).reverse(j)
                            case ("lower", false) => input(i + j)(j)
                            case (_, _)           => throw RuntimeException("not reachable")
                }
            }
        }

        def solve(input: Input): Output = {
            val upper = diagonals(input, "upper", reversed = false, strict = false)
            val upperR = diagonals(input, "upper", reversed = true, strict = false)
            val lower = diagonals(input, "lower", reversed = false, strict = true)
            val lowerR = diagonals(input, "lower", reversed = true, strict = true)
            val diags = upper ++ upperR ++ lower ++ lowerR

            val rows = input
            val cols = input.transpose
            rows.map(search("XMAS", _)).sum
                + rows.map(search("SAMX", _)).sum
                + cols.map(search("XMAS", _)).sum
                + cols.map(search("SAMX", _)).sum
                + diags.map(search("XMAS", _)).sum
                + diags.map(search("SAMX", _)).sum
        }
    }

    object Part2 {
        private type Output = Int

        private def search(word: String, chars: Iterable[Char]): List[Int] = {
            import scala.collection.mutable

            val result = mutable.Buffer.empty[Int]
            var searching = word
            for (c, i) <- chars.zipWithIndex do {
                if c != searching.head then searching = word
                if c == searching.head then searching = searching.tail
                if searching.isEmpty then
                    result.append(i)
                    searching = word
            }
            result.toList
        }

        private def diagonals(input: Input, half: "upper" | "lower", reversed: Boolean, strict: Boolean) = {
            def strictness(i: Int, j: Int) = if strict then (j + i) != j else true
            input.indices.collect { case i =>
                input.transpose.indices.collect {
                    case j if strictness(i, j) && j < input.size - i =>
                        val (x, y) = half match
                            case "upper" => (j, i + j)
                            case "lower" => (i + j, j)
                        if reversed then (input(x).reverse(y), (x, input(x).size - y - 1)) else (input(x)(y), (x, y))
                }
            }
        }

        private def cross(diags: Iterable[IndexedSeq[(Char, (Int, Int))]]) = {
            diags.flatMap { diagonal =>
                List("MAS", "SAM").flatMap { word =>
                    search(word, diagonal.map(_._1)).map(i => diagonal(i - 1))
                }
            }
        }

        def solve(input: Input): Output = {
            val upper = diagonals(input, "upper", reversed = false, strict = false)
            val upperR = diagonals(input, "upper", reversed = true, strict = false)
            val lower = diagonals(input, "lower", reversed = false, strict = true)
            val lowerR = diagonals(input, "lower", reversed = true, strict = true)

            val diags = upper ++ lower
            val diagsR = upperR ++ lowerR
            cross(diags).toList.intersect(cross(diagsR).toList).size
        }
    }
}
