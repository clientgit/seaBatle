import Naval._
import Game.startGame
import scala.io.StdIn


object Main extends App  {

  val field: Field = Vector.fill(10, 10)(false)
  val fleet: Fleet = Map[String, List[(Int, Int)]]()

  print("size of the Fleet: ")
  val currentGame: Game = startGame(StdIn.readInt(), (field, fleet))

  currentGame._2.foreach(nameShip => println(nameShip._1 + " -> " + nameShip._2.sorted))
  currentGame._1.map(line => line
      .map(point => if (point) "@  " else "-  "))
      .foreach(line => println(line.mkString("")))

}