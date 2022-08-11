object Naval {
    type Point = (Int, Int)
    type Ship = List[Point]
    type Fleet = Map[String, Ship]
    type Field = Vector[Vector[Boolean]]
    type Game = (Field, Fleet)
}
