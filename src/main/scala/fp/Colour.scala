package fp

case class ColorIndex(value: Int)
case class Colour(idx: ColorIndex, nuance: Nuance)

sealed trait Nuance
case object Gloss extends Nuance
case object Matte extends Nuance

case class Solution(colors: List[Colour])
case class Preference(colors: List[Colour])