object Day3 {
    private type Input = String

    def parse(input: String): Input = input

    object Part1 {
        private type Output = Int

        private enum State {
            case MatchingChar(char: Char)
            case MatchingX(digits: String = "")
            case MatchingY(x: Int, digits: String = "")
        }

        def solve(input: Input): Output = {
            import scala.collection.mutable

            val results = mutable.Buffer.empty[(Int, Int)]
            val initial = State.MatchingChar('m')
            var state = initial
            for c <- input do {
                state = state match
                    case State.MatchingChar(char @ ('m' | 'u' | 'l' | '(')) if c == char =>
                        char match
                            case 'm' => State.MatchingChar('u')
                            case 'u' => State.MatchingChar('l')
                            case 'l' => State.MatchingChar('(')
                            case '(' => State.MatchingX()
                    case State.MatchingX(digits) if c.isDigit =>
                        State.MatchingX(digits + c)
                    case State.MatchingX(digits) if c == ',' =>
                        State.MatchingY(digits.toInt)
                    case State.MatchingY(x, digits) if c.isDigit =>
                        State.MatchingY(x, digits + c)
                    case State.MatchingY(x, digits) if c == ')' =>
                        results.append((x, digits.toInt))
                        initial
                    case _ =>
                        initial
            }
            results.map(r => r._1 * r._2).sum
        }
    }
}
