package fp

protected[fp] trait Solutions {
  final def add: (Solution, Colour) ⇒ Solution = {
    case (Solution(colours), c)  if !colours.contains(c) ⇒ Solution(c::colours).sorted
    case (solution, _)                                   ⇒ solution.sorted
  }

  final def padd(n : Int): Solution ⇒ Solution = s ⇒ Range(1, n + 1).toSet.diff(s.colors.map(_.idx.value).toSet).foldLeft(s) {
    case (sol, i) ⇒ add(sol, gloss(i))
  }

  final def solution(c: Colour) = Solution(List(c))

  final def solution(c: Colour, c2: Colour, cs: Colour*) = Solution(c::c2::cs.toList)

  implicit class RichSolution(s: Solution) {
    def sorted: Solution = Solution(s.colors.sorted)
  }

  implicit def sortSolution: Ordering[Solution] =
    (x: Solution, y: Solution) ⇒ implicitly[Ordering[Int]].compare(weight(x), weight(y))

  private def weight: Solution ⇒ Int = _.colors.count(_.nuance == Gloss)
}