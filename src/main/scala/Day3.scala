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

    object Part2 {
        private type Output = Int

        private enum State {
            case MatchingChar(char: Char)
            case MatchingDoAmbiguous(last: Char)
            case MatchingDo(char: Char)
            case MatchingDont(char: Char)
            case MatchingX(digits: String = "")
            case MatchingY(x: Int, digits: String = "")
        }

        def solve(input: Input): Output = {
            import scala.collection.mutable

            val results = mutable.Buffer.empty[(Int, Int)]
            val initial = State.MatchingChar('m')
            var state = initial
            var dont = false
            for c <- input do {
                state = state match
                    case _ if c == 'd' => State.MatchingDoAmbiguous(c)
                    case State.MatchingDoAmbiguous(char @ ('d' | 'o')) =>
                        char match
                            case 'd' if c == 'o' => State.MatchingDoAmbiguous(c)
                            case 'o' if c == '(' => State.MatchingDo(')')
                            case 'o' if c == 'n' => State.MatchingDont('\'')
                            case _               => initial
                    case State.MatchingDo(char @ ')') if c == char =>
                        dont = false
                        initial
                    case State.MatchingDont(char @ ('\'' | 't' | '(' | ')')) if c == char =>
                        char match
                            case '\'' => State.MatchingDont('t')
                            case 't'  => State.MatchingDont('(')
                            case '('  => State.MatchingDont(')')
                            case ')' =>
                                dont = true
                                initial
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
                        if !dont then results.append((x, digits.toInt))
                        initial
                    case _ =>
                        initial
            }
            results.map(r => r._1 * r._2).sum
        }
    }
}
