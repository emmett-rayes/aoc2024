object Day4 {
    private type Input = List[List[Char]]

    def parse(input: String): Input =
        input.split("\n").map(_.toCharArray.toList).toList

}
