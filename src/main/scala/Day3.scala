object Day3 {
    private type Input = String

    def parse(input: String): Input = input

    object Part1 {
        private type Output = Int

        def solve(input: Input): Output = {
            import scala.collection.mutable

            val results = mutable.Buffer.empty[(Int, Int)]
            var state: (Char, String, String) = ('m', "", "")
            for c <- input do {
                state = state match
                    case (char @ ('m' | 'u' | 'l' | '('), "", "") if c == char =>
                        char match
                            case 'm' => ('u', "", "")
                            case 'u' => ('l', "", "")
                            case 'l' => ('(', "", "")
                            case '(' => ('x', "", "")
                    case ('x', left, right) if c.isDigit =>
                        ('x', left + c, right)
                    case ('x', left, right) if c == ',' =>
                        ('y', left, right)
                    case ('y', left, right) if c.isDigit =>
                        ('y', left, right + c)
                    case ('y', left, right) if c == ')' =>
                        results.append((left.toInt, right.toInt))
                        ('m', "", "")
                    case _ =>
                        ('m', "", "")
            }
            results.map(r => r._1 * r._2).sum
        }
    }
}
