import Naval.{Field, Fleet, Game, Point, Ship}

import scala.annotation.tailrec
import scala.io.StdIn

object Game {
  @tailrec
  def startGame(size: Int, game: Game): Game = {
    size match {
      case 0 => game
      case _ =>
        print(s"name and size of the Ship number $size (separated by a space): ")
        val nameSize: Array[String] = StdIn.readLine().split(" ")
        startGame(size - 1, tryAddShip(game, nameSize(0), getShip(nameSize(1).toInt)))
    }
  }

  // logical of calls
  private def tryAddShip(game: Game, name: String, ship: Ship): Game = game match {
    case (field, fleet) if validateShip(ship) && validatePosition(ship, field) =>
      (markUsedCells(field, ship), enrichFleet(fleet, name, ship))
    case _ => game
  }

  // getting coordinates and building a ship
  @tailrec
  private def getShip(sizeShip: Int, ship: Ship = Nil): Ship = {
    def getCoordinate: Point = {
      print(s"coordinate: ")
      val coordinate: Array[Int] = StdIn.readLine().split(" ").map(_.toInt)
      (coordinate(0), coordinate(1))
    }

    sizeShip match {
      case 0 => ship
      case _ => getShip(sizeShip - 1, getCoordinate :: ship)
    }
  }

  // checking that the ship has no bends (the width of the ship is always one).
  private def validateShip(ship: Ship): Boolean = {
    @tailrec
    def bendingTest(coordinate: List[Int]): Boolean = coordinate match {
      case _ :: Nil => true
      case head :: tail =>
        if (head == tail.head - 1) bendingTest(tail)
        else false
    }

    if (ship.nonEmpty && ship.length <= 4) {
      val (x, y): (List[Int], List[Int]) = ship.unzip
      if (x.distinct.size == 1 ) bendingTest(y.sorted)
      else if (y.distinct.size == 1) bendingTest(x.sorted)
      else false
    } else false

  }

  // checking that the ship can be located on the field
  private def validatePosition(ship: Ship, field: Field): Boolean = {
    ship.count( {
      case (x, y) if field(x)(y) => false

      case (x, y) if x > 0 && field(x - 1)(y) => false
      case (x, y) if y > 0 && field(x)(y - 1) => false
      case (x, y) if x > 0 && y > 0 && field(x - 1)(y - 1) => false
      case (x, y) if x > 0 && x < 9 && y > 0 && y < 9 && field(x + 1)(y - 1) => false

      case (x, y) if x < 9 && field(x + 1)(y) => false
      case (x, y) if y < 9 && field(x)(y + 1) => false
      case (x, y) if x < 9 && y < 9 && field(x + 1)(y + 1) => false
      case (x, y) if x < 9 && x > 0 && y < 9 && y > 0 && field(x - 1)(y + 1) => false

      case _ => true
    }) == ship.size
  }

  // add ship to fleet
  private def enrichFleet(fleet: Fleet, name: String, ship: Ship): Fleet = fleet + (name -> ship)

  // mark the cells occupied by the added ship
  private def markUsedCells(field: Field, ship: Ship): Field =
    ship.foldLeft(field){ case (f, (x, y)) => f.updated(x, f(x).updated(y, true)) }

}
